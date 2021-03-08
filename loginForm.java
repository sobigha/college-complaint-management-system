package project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class loginForm {
	JFrame frame;
    JLabel email_label,password_lablel;
    JTextField email_textfield;
    JPasswordField password_pass;
    JButton submit_button,clear_button;
    Boolean bool;
    String dbName,Email;

    loginForm() {
        frame = new JFrame();
        frame.setFont(new Font("Dialog", Font.BOLD, 12));
        frame.setBounds(700, 300, 584, 531);
        frame.setTitle("LoginForm");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		

        email_label = new JLabel("Email-ID");
        email_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
        email_label.setBounds(70, 150, 150, 30);
        frame.getContentPane().add(email_label);

        password_lablel = new JLabel("Password");
        password_lablel.setFont(new Font("Yu Gothic", Font.BOLD, 21));
        password_lablel.setBounds(70, 250, 150, 30);
        frame.getContentPane().add(password_lablel );

        email_textfield = new JTextField();
        email_textfield.setBounds(200, 150, 300,30 );
        frame.getContentPane().add(email_textfield);

        password_pass = new JPasswordField();
        password_pass  .setFont(new Font("Yu Gothic", Font.BOLD, 20));
        password_pass  .setBounds(200, 250, 300, 30);
        frame.getContentPane().add(password_pass );

        JCheckBox show_checkbox = new JCheckBox("Show Password");
		show_checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (e.getSource() == show_checkbox ) {
			            if (show_checkbox .isSelected()) {
			            	password_pass.setEchoChar((char)0);
			            } else {
			            	password_pass.setEchoChar('*');
			       }}
			}
		});
		show_checkbox.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		show_checkbox.setBounds(254, 290, 147, 25);
		frame.getContentPane().add(show_checkbox);

        
        submit_button = new JButton("Submit");
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                try{
                	String regexString = "^[0-9]{2}(EU|eu)*[A-Za-z]{2}[0-9]{3}@?skcet\\.ac\\.in$";
            		Email=email_textfield.getText();
            		
            		Pattern r = Pattern.compile(regexString);
            		Matcher m = r.matcher(Email);
            		bool = new Boolean(m.find());
            		@SuppressWarnings("deprecation")
					String Password=password_pass.getText();
            		if(bool==true) {
            			dbName="Db.student";
            		}else{
            			dbName="Db.advisor";
            		}
            		new login().checkcreds(dbName,Email,Password);
                }catch(regexValidation re) {
                	JOptionPane.showMessageDialog(null, re.exString);
                	if(bool==true && re.exString=="Access Granted") {
                		new student_dashboard(Email);
                		frame.setVisible(false);
                	}else if(bool==false && re.exString=="Access Granted"){
                		//Advisor Dashboard
                		new advisorForm(Email);
                		frame.setVisible(false);
                	}
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                    
                }
            }
        });
        submit_button.setFont(new Font("Yu Gothic", Font.BOLD, 22));
        submit_button.setBounds(150, 320, 112, 36);
        frame.getContentPane().add(submit_button);

        clear_button = new JButton("Clear");
        clear_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent cl) {

                email_textfield.setText("");
                password_pass .setText("");
                JOptionPane.showMessageDialog(null, "Form Cleared");
            }
        });
        clear_button.setFont(new Font("Yu Gothic", Font.BOLD, 22));
        clear_button.setBounds(350, 320, 112, 36);
        frame.getContentPane().add(clear_button);
        
        JLabel backgroundJLabel = new JLabel(new ImageIcon(".\\source\\bg2.jpg"));
        backgroundJLabel.setBounds(0,0, 584, 531);
        frame.add(backgroundJLabel);
        frame.setVisible(true);


    }
}
