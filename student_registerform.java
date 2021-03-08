package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

public class student_registerform {
	 JFrame frame; 
     JLabel fullname_label,firstname_label,lastname_label,email_label,confirm_label,password_lablel,gender_label,phone_label,
      roll_label,year_label,dateofbirth_label,dept_label,section_label;
	 JTextField firstname_textfield,lastname_textfield,email_textfield,dateofbirth_textfield,phone_textfield;
	 TextField roll_textfield;
	 JPasswordField password_passwordfield,confirm_passwordfield; 
	 JRadioButton male_radio,female_radio;
	 ButtonGroup bg;
	 JButton submit_button,clear_button;
	 String str_gender="";
 
   student_registerform() {
	    frame = new JFrame();
	    frame.setFont(new Font("Dialog", Font.BOLD, 12));
	    frame.setTitle("Student Registration Form");
	    frame.setBounds(500, 100, 782, 778);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		fullname_label = new JLabel("Full Name");
		fullname_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		fullname_label.setBounds(132, 86, 112, 29);
		frame.getContentPane().add(fullname_label);
		
	    firstname_label = new JLabel("First Name");
	    firstname_label.setForeground(Color.BLACK);
	    firstname_label.setFont(new Font("Yu Gothic", Font.BOLD, 13));
	    firstname_label.setBounds(292, 115, 77, 16);
		frame.getContentPane().add(firstname_label);
		
		lastname_label = new JLabel("Last Name");
		lastname_label.setForeground(Color.BLACK);
		lastname_label.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lastname_label.setBounds(446, 115, 77, 16);
		frame.getContentPane().add(lastname_label);
		
		email_label = new JLabel("Email Address");
		email_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		email_label.setBounds(106, 209, 153, 29);
		frame.getContentPane().add(email_label);
		
		password_lablel = new JLabel("Password");
		password_lablel.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		password_lablel.setBounds(132, 549, 133, 29);
		frame.getContentPane().add(password_lablel );
		
		confirm_label = new JLabel("Confirm Password");
		confirm_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		confirm_label.setBounds(78, 602, 187, 29);
		frame.getContentPane().add(confirm_label );
		
		gender_label= new JLabel("Gender");
		gender_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		gender_label.setBounds(153, 276, 77, 29);
		frame.getContentPane().add(gender_label);
		
		phone_label= new JLabel("Phone Number");
		phone_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		phone_label.setBounds(118, 491, 153, 29);
		frame.getContentPane().add(phone_label);
		
		roll_label = new JLabel("Roll Number");
	    roll_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
	    roll_label.setBounds(132, 147, 127, 29);
		frame.getContentPane().add(roll_label);		

		year_label = new JLabel("Year");
		year_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		year_label.setBounds(153, 375, 77, 36);
		frame.getContentPane().add(year_label );
		
		dateofbirth_label = new JLabel("Date of Birth");
		dateofbirth_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		dateofbirth_label.setBounds(106, 438, 153, 29);
		frame.getContentPane().add(dateofbirth_label);
		
		dept_label = new JLabel("Department");
		dept_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		dept_label.setBounds(132, 318, 127, 36);
		frame.getContentPane().add(dept_label);
		
		section_label = new JLabel("Section");
		section_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		section_label.setBounds(411, 379, 84, 29);
		frame.getContentPane().add(section_label);
			
		male_radio = new JRadioButton("Male");
		male_radio .addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent m) {
				ItemSelectable itemselected=m.getItemSelectable();
		        if(itemselected==male_radio){
		                str_gender="Male";	
			}
		}});
		male_radio.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		male_radio.setBounds(297, 278, 127, 25);
		bg=new ButtonGroup();
		bg.add(male_radio);
		frame.getContentPane().add(male_radio);
		
		female_radio = new JRadioButton("Female");
		female_radio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent f) {
				ItemSelectable itemselected=f.getItemSelectable();
		        if(itemselected==female_radio ){
		                str_gender="Female";	
			}}		
		});
		female_radio.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		female_radio.setBounds(455, 278, 127, 25);
		bg.add(female_radio);
		frame.getContentPane().add(female_radio);
		
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
		section_combobox.setBounds(507, 376, 70, 29);
		section_combobox.addItem("A");
		section_combobox.addItem("B");
		section_combobox.addItem("C");
		frame.getContentPane().add(section_combobox);
		
		JComboBox<String> year_combobox = new JComboBox<String>();
		year_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 16));
	    year_combobox.setBounds(296, 381, 84, 29);
		year_combobox.addItem("1");
		year_combobox.addItem("2");
		year_combobox.addItem("3");
		year_combobox.addItem("4");
		frame.getContentPane().add(year_combobox);
		
		firstname_textfield = new JTextField();
		firstname_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		firstname_textfield.setBounds(282, 84, 142, 29);
		frame.getContentPane().add(firstname_textfield);
		
		lastname_textfield = new JTextField();
		lastname_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lastname_textfield.setBounds(436, 84, 150, 29);
		frame.getContentPane().add(lastname_textfield);
		
		roll_textfield = new TextField();
		roll_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		roll_textfield.setBounds(282, 147, 304, 29);
		frame.getContentPane().add(roll_textfield);
		roll_textfield.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				email_textfield.setText(roll_textfield.getText());
				if(roll_textfield.getText().length()>=2) {
					int y = Integer.valueOf(roll_textfield.getText().substring(0,2));
					year_combobox.setSelectedIndex(20-y);
				}
				if(roll_textfield.getText().length()==9) {
					email_textfield.setText(email_textfield.getText()+"@skcet.ac.in");
					int c = Integer.valueOf(roll_textfield.getText().substring(6,9));
					if(c<=60) {
						section_combobox.setSelectedIndex(0);
					}else if(c<=120) {
						section_combobox.setSelectedIndex(1);
					}else {
						section_combobox.setSelectedIndex(2);
					}
				}
				if(roll_textfield.getText().length()>=6) {
					String[] d = {"CSE","IT","EEE","ECE","MECH","MCT","CIVIL"};
					ArrayList<String> D = new ArrayList<String>();
					D.add("CS");
					D.add("IT");
					D.add("EE");
					D.add("EC");
					D.add("ME");
					D.add("MT");
					D.add("CI");
					
					String tempString = roll_textfield.getText().charAt(4)+""+roll_textfield.getText().charAt(5);
					dept_combobox.setSelectedItem(d[D.indexOf(tempString.toUpperCase())]);
				}
			}
		});
		
		email_textfield = new JTextField();
		email_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		email_textfield.setBounds(281, 211, 305, 29);
		frame.getContentPane().add(email_textfield);
		email_textfield.setEditable(false);
		
		SpinnerDateModel model=new SpinnerDateModel();
		model.setCalendarField(Calendar.HOUR);
		JSpinner startTime=new JSpinner();
		startTime.setModel(model);
		startTime.setBounds(297, 440, 277, 34);
		startTime.setEditor(new JSpinner.DateEditor(startTime,"yyyy-MM-dd"));
		JFormattedTextField dateofbirth_textfield = ((JSpinner.DefaultEditor)startTime.getEditor()).getTextField();
		dateofbirth_textfield.setEditable(false);
	   	frame.getContentPane().add(startTime);
		
	
		phone_textfield = new JTextField();
		phone_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		phone_textfield.setBounds(292, 491, 290, 29);
		frame.getContentPane().add(phone_textfield);
			
	    password_passwordfield = new JPasswordField();
	    password_passwordfield .setFont(new Font("Yu Gothic", Font.BOLD, 20));
	    password_passwordfield .setBounds(292, 549, 290, 29);
		frame.getContentPane().add(password_passwordfield );
		
		confirm_passwordfield = new JPasswordField();
		confirm_passwordfield .setFont(new Font("Yu Gothic", Font.BOLD, 20));
		confirm_passwordfield .setBounds(292, 602, 290, 29);
		frame.getContentPane().add(confirm_passwordfield );
		
	
        submit_button = new JButton("Submit");
        submit_button.addActionListener(new ActionListener() {
        	
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
						
			            try{             
			            	Student student = new Student();
			                student.firstname =firstname_textfield.getText();
			                student.lastname=lastname_textfield.getText();
                            student.regno=roll_textfield.getText().toUpperCase();
                            student.gender=str_gender;
                            student.year=year_combobox.getSelectedItem().toString();
                            student.section=section_combobox.getSelectedItem().toString();
                            student.depart=dept_combobox.getSelectedItem().toString();
                            student.email=email_textfield.getText();
                            student.dob=dateofbirth_textfield.getText();
                            student.phonenumber=phone_textfield.getText();

                            if(password_passwordfield.getText().toString().equals(confirm_passwordfield.getText().toString())==false) {
                            	throw new regexValidation("Password Did not Match");
                            }
                            
                            //Regex Validation
                            regexValidation regex = new regexValidation();
                            regex.regexvalid((Student) student);
                            
                            password p1=new password();
                            String encrypedString = p1.regexString(new String(password_passwordfield.getText()));
                            if("Password Did not match the requirement" == encrypedString){
                            	throw new regexValidation(encrypedString);
                            }
			                student.password=encrypedString;
			        		
			                register reg = new register();
			                student.otp=reg.otp();
			                new sendmail(student.email,student.otp);
			                String string = JOptionPane.showInputDialog(frame,"Enter the OTP");

			                if (student.otp.equals(string)==false) {
			                	throw new regexValidation("Wrong OTP");
			                }
			                student.otp="";
	                		if (reg.appendRow((Student) student) == 1) 
	                			throw new regexValidation("Registration Success!");
	                		else
	                			throw new regexValidation("Registration Failed");
			              }
			            catch (regexValidation ex) {
			            	JOptionPane.showMessageDialog(null,ex.exString);
						}
			            catch(Exception ex){
			                JOptionPane.showMessageDialog(null, ex);
			            }
			            
			        }
		});
        submit_button.setFont(new Font("Yu Gothic", Font.BOLD, 22));
        submit_button.setBounds(232, 662, 112, 36);
		frame.getContentPane().add(submit_button);
		
		clear_button = new JButton("Clear");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cl) {
				
				firstname_textfield.setText("");
				lastname_textfield.setText("");
				roll_textfield.setText("");
				email_textfield.setText(""); 
				dateofbirth_textfield.setText("");
				phone_textfield.setText("");
				password_passwordfield.setText("");
				confirm_passwordfield.setText("");
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