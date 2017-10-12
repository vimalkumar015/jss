package jssoriginal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class lastduedetail {

	private JFrame frmJssLast;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	static String tablename1;
	static String tablename2;
	static String name;
	static String date;
	static String lastduenum;
	static String amount;
	static int status;
	private JLabel lblAccountStatus;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String tablename) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tablename1=tablename;
					tablename2="user"+tablename1;
					data();
					lastduedetail window = new lastduedetail();
					window.frmJssLast.setVisible(true);
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
			PreparedStatement stmt=con.prepareStatement("select acholdername,flag from custdetails where sno="+tablename1+"");
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
			name = rs.getString(1);
			status=rs.getInt(2);
			}
			PreparedStatement stmt1=con.prepareStatement("select * from "+tablename2+" where duenumber=(select max(duenumber) from "+tablename2+")");
			ResultSet rs1=stmt1.executeQuery();
			if(rs1.next())
			{
				date =rs1.getString(1);
				lastduenum=Integer.toString(rs1.getInt(2));
				amount=Integer.toString(rs1.getInt(3));
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	public lastduedetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJssLast = new JFrame();
		frmJssLast.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 14));
		frmJssLast.getContentPane().setBackground(new Color(176, 224, 230));
		frmJssLast.setTitle("JSS - Last Due Detail");
		frmJssLast.setBounds(100, 100, 450, 300);
		frmJssLast.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(tablename1);
		textField.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(name);
		textField_1.setColumns(10);
		
		JLabel lblSchemePlan = new JLabel("Scheme Plan");
		lblSchemePlan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(amount);
		textField_2.setColumns(10);
		
		JLabel lblLastPaidDue = new JLabel("Last Paid Due");
		lblLastPaidDue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText(lastduenum);
		textField_3.setColumns(10);
		
		JLabel lblLastDueDate = new JLabel("Last Due Date");
		lblLastDueDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText(date);
		textField_4.setColumns(10);
		
		JButton btnClose = new JButton("Home");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage.main(null);
				frmJssLast.dispose();
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		lblAccountStatus = new JLabel("Account Status");
		lblAccountStatus.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		if(status==1)
		{
			textField_5.setText("OPEN");
		}
		else
		{
			textField_5.setText("CLOSED");
		}
		textField_5.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmJssLast.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSerialNumber)
						.addComponent(lblCustomerName)
						.addComponent(lblSchemePlan)
						.addComponent(lblLastDueDate)
						.addComponent(lblLastPaidDue)
						.addComponent(lblAccountStatus))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnClose)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField_5, Alignment.LEADING)
							.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSerialNumber)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomerName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSchemePlan)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastPaidDue))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addComponent(btnClose)
							.addGap(29))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLastDueDate)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAccountStatus)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(76))))
		);
		frmJssLast.getContentPane().setLayout(groupLayout);
	}

}
