package jssoriginal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newentry {

	protected static final String String = null;
	private JFrame frmNewEntry;
	private JTextField textField_serialnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newentry window = new newentry();
					window.frmNewEntry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newentry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewEntry = new JFrame();
		frmNewEntry.setTitle("JSS - New Entry");
		frmNewEntry.getContentPane().setBackground(new Color(176, 224, 230));
		frmNewEntry.setBounds(100, 100, 450, 300);
		frmNewEntry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField_serialnumber = new JTextField();
		textField_serialnumber.setColumns(10);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnRetrive = new JButton("Retrive");
		btnRetrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tablename=textField_serialnumber.getText();
				newentry1.main(tablename);
				frmNewEntry.dispose();
			}
		});
		
		JButton btnback= new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homepage.main(null);
				frmNewEntry.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmNewEntry.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(lblSerialNumber)
							.addGap(38)
							.addComponent(textField_serialnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(btnRetrive)
							.addGap(60)
							.addComponent(btnback)))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSerialNumber)
						.addComponent(textField_serialnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRetrive)
						.addComponent(btnback))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		frmNewEntry.getContentPane().setLayout(groupLayout);
	}
}
