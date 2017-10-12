package jssoriginal;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Font;


public class login {

	private JFrame frmJss;
	private JTextField Jtextfield_username;
	private JPasswordField jpasswordfield_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmJss.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJss = new JFrame();
		frmJss.setBackground(new Color(255, 255, 255));
		frmJss.getContentPane().setBackground(new Color(176, 224, 230));
		frmJss.setTitle("JSS - JEWEL SAVING SCHEME");
		frmJss.setBounds(100, 100, 450, 300);
		frmJss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUserName = new JLabel("User Name");
		
		JLabel lblPassword = new JLabel("Password");
		
		Jtextfield_username = new JTextField();
		Jtextfield_username.setColumns(10);
		
		
		
		//code for the login button
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{  // db connection
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","scott","tiger");
					//quering to check the username and pass
					PreparedStatement stmt=con.prepareStatement("select username,pass from login where username=? and pass=?");
					//getting the runtime input1
					stmt.setString(1, Jtextfield_username.getText() );
					//getting the runtime input2
					stmt.setString(2, String.valueOf(jpasswordfield_password.getPassword()));
					ResultSet rs=stmt.executeQuery();
					if(rs.next())
					{
						
						homepage.main(null);
						frmJss.dispose();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Username or password","info",JOptionPane.INFORMATION_MESSAGE);
						
					}
					
					
				}
				catch(Exception e1)
				{ System.out.println(e1);
				}
				
				
			}
		});
		//code for the cancel button
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		jpasswordfield_password = new JPasswordField();
		jpasswordfield_password.setEchoChar('*');
		
		JCheckBox cb_showpassword = new JCheckBox("Show Password");
		cb_showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb_showpassword.isSelected())
				{
					jpasswordfield_password.setEchoChar((char)0);
				}
				else
				{
					jpasswordfield_password.setEchoChar('*');
			}
			}
		});
		cb_showpassword.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		cb_showpassword.setBackground(new Color(176, 224, 230));
		GroupLayout groupLayout = new GroupLayout(frmJss.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUserName)
								.addComponent(lblPassword))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jpasswordfield_password)
								.addComponent(Jtextfield_username, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(cb_showpassword, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addComponent(btnLogin)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnCancel)))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserName)
						.addComponent(Jtextfield_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(jpasswordfield_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cb_showpassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnCancel))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		frmJss.getContentPane().setLayout(groupLayout);
	}
}
