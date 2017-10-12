package jssoriginal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class newentry1 {

	
	private JFrame frmJssNew;
	private JTextField textField;
	static String tablename;
	static String tablename1;
	static String name;
	static int duenumber;
	static String duenum;
	static int dueamount;
	static String dueamt;
	static Date date;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String tablename2) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tablename=tablename2;
					tablename1="user"+tablename;
					data();
					if(duenumber<=15)
					{
					newentry1 window = new newentry1(null);
					window.frmJssNew.setVisible(true);
					}
					else
					{	
						JOptionPane.showMessageDialog(null, "15 Due completed!\nplease come after one month from the last due date to collect Scheme Benifits");
						homepage.main(null);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	
	public static void data()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","scott","tiger");
			PreparedStatement stmt=con.prepareStatement("select acholdername from custdetails where sno="+tablename+"");
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
			name = rs.getString(1);
			}
			PreparedStatement stmt1=con.prepareStatement("select * from "+tablename1+" where duenumber=(select max(duenumber) from "+tablename1+")");
			ResultSet rs1=stmt1.executeQuery();
			if(rs1.next())
			{
			duenumber =	rs1.getInt(2)+1;
			duenum=(new Integer(duenumber)).toString();
			dueamount = rs1.getInt(3);
			dueamt=(new Integer(dueamount)).toString();
			}
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
	}
	public newentry1(String msg) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJssNew = new JFrame();
		frmJssNew.setTitle("JSS - New Entry");
		frmJssNew.getContentPane().setBackground(new Color(176, 224, 230));
		frmJssNew.setBounds(100, 100, 450, 300);
		frmJssNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(tablename);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setColumns(10);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(name);
		textField_1.setColumns(10);
		
		JLabel lblNewDueNumber = new JLabel("New Due Number");
		lblNewDueNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(duenum);
		textField_2.setColumns(10);
		
		JLabel lblDueAmount = new JLabel("Due Amount");
		lblDueAmount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText(dueamt);
		textField_3.setColumns(10);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","scott","tiger");
				PreparedStatement stmt=con.prepareStatement("insert into "+tablename1+" values (sysdate,"+duenumber+","+dueamount+")");
				int rs=stmt.executeUpdate();
				if(rs==0)
				{
					JOptionPane.showMessageDialog(null, "OOPS! Something went Wrong, please try again");
					frmJssNew.dispose();
					homepage.main(null);
				}
				else
				{ if(duenumber==2)
				{
					JOptionPane.showMessageDialog(null, "Account Updated\nplease collect "+duenumber+"nd Due Amount rupees "+dueamount+"");
					frmJssNew.dispose();
					homepage.main(null);
				}else if(duenumber==3)
				{
					JOptionPane.showMessageDialog(null, "Account Updated\nplease collect "+duenumber+"rd Due Amount rupees "+dueamount+"");
					frmJssNew.dispose();
					homepage.main(null);
				}else if(duenumber>=3)
				{
					JOptionPane.showMessageDialog(null, "Account Updated\nplease collect "+duenumber+"th Due Amount rupees "+dueamount+"");
					frmJssNew.dispose();
					homepage.main(null);
				}
				}
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnPay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homepage.main(null);
				frmJssNew.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frmJssNew.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSerialNumber)
								.addComponent(lblCustomerName)
								.addComponent(lblNewDueNumber)
								.addComponent(lblDueAmount)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(btnPay)))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSerialNumber))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomerName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewDueNumber)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDueAmount))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPay)
						.addComponent(btnNewButton))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		frmJssNew.getContentPane().setLayout(groupLayout);
	}
}
