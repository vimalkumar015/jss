package jssoriginal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class accountclosenavi {

	private JFrame frmJssClose;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accountclosenavi window = new accountclosenavi();
					window.frmJssClose.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public accountclosenavi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJssClose = new JFrame();
		frmJssClose.setTitle("JSS - Close Account");
		frmJssClose.getContentPane().setBackground(new Color(176, 224, 230));
		frmJssClose.setBounds(100, 100, 450, 300);
		frmJssClose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnCloseAccount = new JButton("Close Account");
		btnCloseAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","scott","tiger");
					String tablename = textField.getText();
					String tablename1 = "user"+tablename;
					String tablename3 = "closed"+tablename;
					PreparedStatement stmt0=con.prepareStatement("select duenumber,dueamount from "+tablename1+" where duenumber=(select max(duenumber) from "+tablename1+")");
					ResultSet rs0=stmt0.executeQuery();
					int duenum=0;
					int dueamount=0;
					if(rs0.next())
					{
					duenum=rs0.getInt(1);
					dueamount=rs0.getInt(2);
					System.out.println("start");
					}
					PreparedStatement stmt=con.prepareStatement("alter table "+tablename1+" rename to "+tablename3+"");
					stmt.execute();
					System.out.println("done");
					PreparedStatement stmt1=con.prepareStatement("update custdetails set flag=1 where sno="+tablename+" ");
					int rs=stmt1.executeUpdate();
					if(rs==0)
					{
						System.out.println("donedone");
					}
					if(duenum<15)
					{
						JOptionPane.showMessageDialog(null, "Account Closed");
						JOptionPane.showMessageDialog(null, "Total Scheme Amount is "+dueamount*(duenum-1)+"");
						homepage.main(null);
						frmJssClose.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Total Scheme Amount with benifits is "+dueamount*(duenum+2)+"");
						homepage.main(null);
						frmJssClose.dispose();
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnCloseAccount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage.main(null);
				frmJssClose.dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frmJssClose.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(lblSerialNumber)
							.addGap(35)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(btnCloseAccount)
							.addGap(68)
							.addComponent(btnCancel)))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSerialNumber)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCloseAccount)
						.addComponent(btnCancel))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		frmJssClose.getContentPane().setLayout(groupLayout);
	}

}
