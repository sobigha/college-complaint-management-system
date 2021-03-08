package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  
public class admin_login
{
	JFrame frame,frame2;
	JLabel username_label,password_label;
	JTextField username_textfield;
	JPasswordField password_passwordfield ;
	JCheckBox show_checkbox;
	JButton signin_button;

    public admin_login() {
    	frame = new JFrame();		
		frame.setTitle("Login Form");
		frame.setBounds(700, 300, 584, 531);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
			
		username_label= new JLabel("Username");
		username_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		username_label.setBounds(123, 141, 124, 25);
		frame.getContentPane().add(username_label);
		
		password_label= new JLabel("Password");
		password_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		password_label.setBounds(123, 243, 109, 25);
		frame.getContentPane().add(password_label);
		
		username_textfield = new JTextField();
		username_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		username_textfield.setBounds(259, 134, 227, 39);
		frame.getContentPane().add(username_textfield );
	
	    password_passwordfield = new JPasswordField();
	    password_passwordfield .setFont(new Font("Yu Gothic", Font.BOLD, 20));
	    password_passwordfield .setBounds(259, 236, 227, 39);
		frame.getContentPane().add(password_passwordfield);
		
		show_checkbox = new JCheckBox("Show Password");
		show_checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (e.getSource() == show_checkbox ) {
			            if (show_checkbox .isSelected()) {
			            	password_passwordfield.setEchoChar((char)0);
			            } else {
			            	password_passwordfield.setEchoChar('*');
			       }}
			}
		});
		show_checkbox.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		show_checkbox.setBounds(254, 290, 147, 25);
		frame.getContentPane().add(show_checkbox);
		  
		signin_button = new JButton("Sign in");
		signin_button.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		signin_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String username=username_textfield.getText(),password=  password_passwordfield.getText();
				try {
					new login().checkcreds("Db.admin",username,password);
				} catch (regexValidation e1) {
					JOptionPane.showMessageDialog(null, e1.exString);
					if(e1.exString == "Access Granted") {
						new admin_dashboard();
						frame.setVisible(false);
					}
						
				}
				
			}
		});

		signin_button.setBounds(221, 339, 117, 39);
		frame.getContentPane().add(signin_button);
		
		JLabel backgroundJLabel = new JLabel(new ImageIcon("source\\bg2.jpg")); //\\src\\project
        backgroundJLabel.setBounds(0,0, 584, 531);
        frame.add(backgroundJLabel);
		
		frame.setVisible(true);
  
	}
}

