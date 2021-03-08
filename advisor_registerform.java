package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;  

public class advisor_registerform {
	JFrame frame;
    JLabel fullname_label,firstname_label, lastname_label,email_label,password_label,dept_label,confirm_label,section_label,gender_label,phone_label,year_label;
	JTextField firstname_textfield,lastname_textfield,email_textfield,phone_textfield;
	JPasswordField password_passwordfield,confirm_passwordfield;
    JRadioButton male_radiobutton,female_radiobutton;
	ButtonGroup bg;
	JButton submit_button,clear_button;
	String str_gender="";
	
	advisor_registerform() {
		frame = new JFrame();
	    frame.setTitle("Registration Form");
	    frame.setBounds(500, 100, 782, 778);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		fullname_label = new JLabel("Full Name");
		fullname_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		fullname_label.setBounds(132, 86, 112, 29);
		frame.getContentPane().add(fullname_label);
		
		firstname_label = new JLabel("First name");
		firstname_label.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		firstname_label.setForeground(Color.GRAY);
		firstname_label.setBounds(284, 120, 77, 16);
		frame.getContentPane().add(firstname_label);
		
	    lastname_label = new JLabel("Last name");
		lastname_label.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lastname_label.setForeground(Color.GRAY);
		lastname_label.setBounds(446, 120, 77, 16);
		frame.getContentPane().add(lastname_label);
		
		email_label = new JLabel("Email Address");
		email_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		email_label.setBounds(94, 174, 153, 29);
		frame.getContentPane().add(email_label);
		
		gender_label= new JLabel("Gender");
		gender_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		gender_label.setBounds(153, 254, 77, 29);
		frame.getContentPane().add(gender_label);
			
		password_label = new JLabel("Password");
		password_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		password_label.setBounds(132, 531, 133, 29);
		frame.getContentPane().add(password_label);
		
		confirm_label = new JLabel("Confirm Password");
		confirm_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		confirm_label.setBounds(78, 588, 187, 29);
		frame.getContentPane().add(confirm_label);
		
		phone_label = new JLabel("Phone Number");
		phone_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		phone_label.setBounds(114, 469, 153, 29);
		frame.getContentPane().add(phone_label);
		
		dept_label = new JLabel("Department");
		dept_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		dept_label.setBounds(132, 318, 127, 36);
		frame.getContentPane().add(dept_label);
			
		section_label = new JLabel("Section");
		section_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		section_label.setBounds(411, 393, 84, 29);
		frame.getContentPane().add(section_label);
		
		year_label = new JLabel("Year");
		year_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		year_label.setBounds(153, 389, 77, 36);
		frame.getContentPane().add(year_label);
		
		male_radiobutton = new JRadioButton("Male");
		male_radiobutton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent m) {
				ItemSelectable itemselected=m.getItemSelectable();
		        if(itemselected==male_radiobutton ){
		                str_gender="Male";	
			}
		}});
		male_radiobutton.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		male_radiobutton.setBounds(284, 256, 127, 25);
		bg=new ButtonGroup();
		bg.add(male_radiobutton);
		frame.getContentPane().add(male_radiobutton);
		
		female_radiobutton = new JRadioButton("Female");
		female_radiobutton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent f) {
				ItemSelectable itemselected=f.getItemSelectable();
		        if(itemselected==female_radiobutton ){
		                str_gender="Female";	
			}}		
		});
		female_radiobutton.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		female_radiobutton.setBounds(446, 256, 127, 25);
		bg.add(female_radiobutton);
		frame.getContentPane().add(female_radiobutton);
		
	    firstname_textfield = new JTextField();
	    firstname_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		firstname_textfield.setBounds(284, 84, 140, 29);
		frame.getContentPane().add(firstname_textfield);
		
		lastname_textfield = new JTextField();
		lastname_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lastname_textfield.setBounds(436, 84, 150, 29);
		frame.getContentPane().add(lastname_textfield);
		
		email_textfield = new JTextField();
		email_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		email_textfield.setBounds(282, 176, 305, 29);
		frame.getContentPane().add(email_textfield);
	
	    password_passwordfield = new JPasswordField();
	    password_passwordfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		password_passwordfield.setBounds(292, 531, 290, 29);
		frame.getContentPane().add(password_passwordfield);
		
		confirm_passwordfield = new JPasswordField();
		confirm_passwordfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		confirm_passwordfield.setBounds(292, 588, 290, 29);
		frame.getContentPane().add(confirm_passwordfield);
		
		phone_textfield = new JTextField();
		phone_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		phone_textfield.setBounds(292, 469, 290, 29);
		frame.getContentPane().add(phone_textfield);
		

		JComboBox<String> dept_combobox= new JComboBox<String>();
		dept_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		dept_combobox.setBounds(303, 323, 121, 29);
		dept_combobox.addItem("CSE");
        dept_combobox.addItem("IT");
        dept_combobox.addItem("EEE");
        dept_combobox.addItem("ECE");
        dept_combobox.addItem("MECH");
        dept_combobox.addItem("MCT");
        dept_combobox.addItem("CIVIL");
		frame.getContentPane().add(dept_combobox);
		
		JComboBox<String> section_combobox = new JComboBox<String>();
		section_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		section_combobox.setBounds(507, 393, 70, 29);
		section_combobox.addItem("A");
        section_combobox.addItem("B");
        section_combobox.addItem("C");
		frame.getContentPane().add(section_combobox);
		
		JComboBox<String> year_combobox = new JComboBox<String>();
		year_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		year_combobox.setBounds(296, 395, 84, 29);
		year_combobox.addItem("1");
		year_combobox.addItem("2");
		year_combobox.addItem("3");
		year_combobox.addItem("4");
		frame.getContentPane().add(year_combobox);
		
        submit_button = new JButton("Submit");
		submit_button.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		submit_button.setBounds(232, 662, 112, 36);
		frame.getContentPane().add(submit_button);
		
		  submit_button.addActionListener(new ActionListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Advisor advisor = new Advisor();
						advisor.adclass=section_combobox.getSelectedItem().toString();
						advisor.firstname=firstname_textfield.getText();
						advisor.lastname=lastname_textfield.getText();
						advisor.email=email_textfield.getText();
						advisor.phonenumber=phone_textfield.getText();
						advisor.department=dept_combobox.getSelectedItem().toString();
						advisor.gender=str_gender;
						advisor.year=year_combobox.getSelectedItem().toString();
						
						//Regex Validation
	                    regexValidation regex = new regexValidation();
	                    regex.regexvalid((Advisor) advisor);
						
						if(password_passwordfield.getText().toString().equals(confirm_passwordfield.getText().toString())==false) {
	                    	throw new regexValidation("Password Did not Match");
	                    }
						
	                    password p1=new password();
	                    String encrypedString = p1.regexString(new String(password_passwordfield.getText()));
	                    if("Password Did not match the requirement" == encrypedString){
	                    	throw new regexValidation(encrypedString);
	                    }
	                    advisor.password=encrypedString;
						
						register reg = new register();
						advisor.otp=reg.otp();
						new sendmail(advisor.email,advisor.otp);
						String string = JOptionPane.showInputDialog(frame,"Enter the OTP");

		                if (advisor.otp.equals(string)==false) {
		                	throw new regexValidation("Wrong OTP");
		                }
		                advisor.otp="";
						reg.appendRow(advisor);
						JOptionPane.showMessageDialog(null, "Registration Success!");
					} catch (regexValidation e1) {
						JOptionPane.showMessageDialog(null, e1.exString);
					}catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.toString());
					} 
					
				}
			});
		
		clear_button = new JButton("Clear");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cl) {
				
				lastname_textfield.setText("");
			    password_passwordfield.setText(""); 
				confirm_passwordfield.setText("");
				phone_textfield.setText("");
				bg.clearSelection(); 
				JOptionPane.showMessageDialog(null, "Cleared Successfully");
			}
		});
		clear_button.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		clear_button.setBounds(411, 662, 112, 36);
		frame.getContentPane().add(clear_button);   
		
		JLabel backgroundJLabel = new JLabel(new ImageIcon("source\\image2.jpg")); //\\src\\project
        backgroundJLabel.setBounds(0,0,782,778);
        frame.add(backgroundJLabel);
		
		frame.setVisible(true);
	}
}
