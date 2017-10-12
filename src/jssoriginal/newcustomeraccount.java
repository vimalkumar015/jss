package jssoriginal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class newcustomeraccount {

	private JFrame frame;
	private JTextField textField_serialnumber;
	private JTextField textField_acholdername;
	private JTextField textField_1_correspondingname;
	private JTextField textField_doornumber;
	private JTextField textField_1_streetname;
	private JTextField textField_2_village;
	private JTextField textField_3_city;
	private JTextField textField_4_planamount;
	private JTextField textField_5_pincode;
	private JTextField textField_6_mobilenumber;
	public String combo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newcustomeraccount window = new newcustomeraccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newcustomeraccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		
		JLabel lblSerialNo = new JLabel("Serial No.");
		lblSerialNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_serialnumber = new JTextField();
		textField_serialnumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_serialnumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		textField_serialnumber.setColumns(10);
		
		JLabel lblAccountHolderName = new JLabel("Account Holder Name");
		lblAccountHolderName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_acholdername = new JTextField();
		textField_acholdername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_acholdername.setColumns(10);
		
		JComboBox<String> comboBox_raltion = new JComboBox<String>();
		comboBox_raltion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox_raltion.setModel(new DefaultComboBoxModel<String>(new String[] {"H/O", "W/O", "F/O", "M/O", "D/O", "S/O", "G/O", "C/O"}));
		
		JLabel lblCorrespondingName = new JLabel("Corresponding Name");
		lblCorrespondingName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_1_correspondingname = new JTextField();
		textField_1_correspondingname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Residentioal Details");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_doornumber = new JTextField();
		textField_doornumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField_doornumber.setToolTipText("Enter Door Number");
		textField_doornumber.setColumns(10);
		
		textField_1_streetname = new JTextField();
		textField_1_streetname.setToolTipText("Enter building name, street name");
		textField_1_streetname.setColumns(10);
		
		textField_2_village = new JTextField();
		textField_2_village.setToolTipText("Enter Village Name");
		textField_2_village.setColumns(10);
		
		textField_3_city = new JTextField();
		textField_3_city.setToolTipText("Enter City Name");
		textField_3_city.setColumns(10);
		
		JLabel lblSchemePlan = new JLabel("Scheme Plan");
		lblSchemePlan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_4_planamount = new JTextField();
		textField_4_planamount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_4_planamount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE ))
				{
					e.consume();
				}
			}
		});
		textField_4_planamount.setToolTipText("minimum amount is 300");
		textField_4_planamount.setColumns(10);
		
		textField_5_pincode = new JTextField();
		textField_5_pincode.setToolTipText("Enter pincode");
		textField_5_pincode.setColumns(10);
		
		JLabel lblDoorNo = new JLabel("Door No.");
		lblDoorNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblVillageName = new JLabel("Village");
		lblVillageName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblPincode = new JLabel("PinCode");
		lblPincode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_6_mobilenumber = new JTextField();
		textField_6_mobilenumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_6_mobilenumber.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE))
				{
					e.consume();
				}
				
			}			
		});
		textField_6_mobilenumber.setColumns(10);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_serialnumber.getText().trim().length() == 0 && textField_acholdername.getText().trim().length()==0 && textField_4_planamount.getText().trim().length()==0 && textField_6_mobilenumber.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Serial Number, A/C Holder Name, Scheme Plan, Mobile Number");
				}
				else if(textField_serialnumber.getText().trim().length()==0 && textField_acholdername.getText().trim().length()==0 && textField_4_planamount.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Serial Number, A/C Holder Name, Scheme Plan");
				}
				else if(textField_serialnumber.getText().trim().length()==0&& textField_acholdername.getText().trim().length()==0& textField_6_mobilenumber.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Serial Number, A/C Holder Name, Mobile Number");
				}
				else if(textField_serialnumber.getText().trim().length()==0 && textField_4_planamount.getText().trim().length()==0 && textField_6_mobilenumber.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Serial Number, Scheme Plan, Mobile Number");
				}
				else if(textField_acholdername.getText().trim().length()==0 && textField_4_planamount.getText().trim().length()==0 && textField_6_mobilenumber.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the A/C Holder Name, Scheme Plan, Mobile Number");
				}
				else if(textField_acholdername.getText().trim().length()==0 && textField_4_planamount.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the A/C Holder Name, Scheme Plan");
				}
				else if(textField_serialnumber.getText().trim().length()==0 && textField_acholdername.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Serial Number, A/C Holder Name");
				}
				else if(textField_serialnumber.getText().trim().length()==0 && textField_4_planamount.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Serial Number, Scheme Plan");
				}
				else if(textField_serialnumber.getText().trim().length()==0 && textField_6_mobilenumber.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Serial Number, Mobile Number");
				}
				else if(textField_acholdername.getText().trim().length()==0 && textField_6_mobilenumber.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the A/C Holder Name, Mobile Number");
				}
				else if(textField_4_planamount.getText().trim().length()==0 && textField_6_mobilenumber.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Scheme Plan, Mobile Number");
				}
				else if(textField_acholdername.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the A/C Holder Name");
				}
				else if(textField_serialnumber.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Serial Number");
				}
				else if(textField_4_planamount.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Scheme Plan");
				}
				else if(textField_6_mobilenumber.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter the Mobile Number");
				}
				else
				{
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","scott","tiger");
						String tablename="user"+textField_serialnumber.getText();
						PreparedStatement st1=con.prepareStatement("insert into custdetails values(?,?,?,?,?,?,?,?,?,?,1)");
						st1.setInt(1,Integer.parseInt(textField_serialnumber.getText()));
						st1.setString(2, textField_acholdername.getText());
						st1.setDouble(3,Double.parseDouble(textField_6_mobilenumber.getText()));
						st1.setString(4, (String)comboBox_raltion.getSelectedItem());
						st1.setString(5, textField_1_correspondingname.getText());
						st1.setString(6, textField_doornumber.getText());
						st1.setString(7, textField_1_streetname.getText());
						st1.setString(8, textField_2_village.getText());
						st1.setString(9, textField_3_city.getText());
						st1.setInt(10, Integer.parseInt(textField_5_pincode.getText()));
						ResultSet rs1=st1.executeQuery();
						if(rs1.next())
						{
							JOptionPane.showMessageDialog(null, "customer details updated");
						}
						
						PreparedStatement st2=con.prepareStatement("create table "+tablename+" (duedate date,duenumber number(5),dueamount number(6))");
						st2.execute();
						PreparedStatement st3=con.prepareStatement("select count(duenumber) from "+tablename+"");
						ResultSet rs3=st3.executeQuery();
						String count = null;
						if (rs3.next())
						{
							count=rs3.getString(1);
							
									
						}
						PreparedStatement st4=con.prepareStatement("Insert into "+tablename+" values (sysdate,"+count+1+","+Integer.parseInt(textField_4_planamount.getText())+")");
						int rs4=st4.executeUpdate();
						if(rs4==0)
						{
							JOptionPane.showMessageDialog(null, "Something went Wrong!");
						}else
						{
						     JOptionPane.showMessageDialog(null, "New Acoount Created");
						}
						}
						
						
					
				
					catch(Exception e2)
					{
						System.out.println(e2);
					}
					
					
				}
			}
		});
		
		JButton button_exit = new JButton("Back");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homepage.main(null);
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAddress)
							.addContainerGap(474, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSerialNo)
								.addComponent(lblAccountHolderName)
								.addComponent(lblCorrespondingName)
								.addComponent(lblDoorNo)
								.addComponent(lblStreetName)
								.addComponent(lblVillageName)
								.addComponent(lblCity)
								.addComponent(lblPincode)
								.addComponent(lblMobileNo))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_6_mobilenumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(349, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_serialnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(56)
									.addComponent(lblSchemePlan)
									.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
									.addComponent(textField_4_planamount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(26))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_doornumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1_streetname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_2_village, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_3_city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_5_pincode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1_correspondingname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_raltion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_acholdername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button_exit)
											.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addComponent(btnSubmit)
											.addGap(114))))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSerialNo)
						.addComponent(textField_serialnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAccountHolderName)
						.addComponent(textField_acholdername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_raltion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorrespondingName)
						.addComponent(textField_1_correspondingname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAddress)
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_doornumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDoorNo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1_streetname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStreetName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2_village, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVillageName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3_city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5_pincode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPincode))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobileNo)
						.addComponent(textField_6_mobilenumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSchemePlan)
						.addComponent(textField_4_planamount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(137)
					.addComponent(btnSubmit)
					.addGap(18)
					.addComponent(button_exit)
					.addGap(125))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 623, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
