package project;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Color;

public class student_dashboard {

	 JFrame frame;
	 JSeparator separator_1,separator_2,separator_3;
	 JButton complaint_button,creditpoint_button,status_button;
	 JLabel complaint_label,creditpoint_label, status_label,background;
	 sqlconnect sql;
     Statement stmt;
     ResultSet rs;
	 

    student_dashboard(String Email){
		frame = new JFrame();
		frame.setTitle("Student Dashboard");
		frame.setBounds(600, 250, 621, 506);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
	    separator_1 = new JSeparator();
		separator_1.setBounds(41, 125, 532, 43);
		frame.getContentPane().add(separator_1);
		
	    separator_2 = new JSeparator();
		separator_2.setBounds(41, 234, 532, 32);
		frame.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(47, 350, 526, 43);
		frame.getContentPane().add(separator_3);
		
        complaint_button = new JButton("Complaint Form");
    	complaint_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   new complaintform();
			}
		});
		complaint_button.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		complaint_button.setBounds(362, 66, 188, 32);
		frame.getContentPane().add(complaint_button);
	
		creditpoint_button = new JButton("View Credit Points");
		creditpoint_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 sql=new sqlconnect();
			    	 stmt=sql.con.createStatement();
			    	 rs=stmt.executeQuery("select * from Db.student where email='"+Email+"'");
			    	 rs.next();
			    	 new creditform(rs.getString("CREDIT_POINT"));
				}catch(Exception e1) {
					System.out.println(e1.toString());
				}
			}
		});
		creditpoint_button.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		creditpoint_button.setBounds(41, 172, 195, 32);
		frame.getContentPane().add(creditpoint_button);
		
		status_button = new JButton("Track your Complaint");
		status_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 sql=new sqlconnect();
		    	 stmt=sql.con.createStatement();
		    	 rs=stmt.executeQuery("select * from Db.student where email='"+Email+"'");
		    	 rs.next();
				 new statusform(rs.getString("REGNO"));
				}catch(Exception e1) {
					System.out.println(e1.toString());
				}
			}
		});
		status_button.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		status_button.setBounds(378, 284, 195, 32);
		frame.getContentPane().add(status_button);
		
		complaint_label = new JLabel("File a Complaint ---->");
		complaint_label.setForeground(Color.RED);
		complaint_label.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		complaint_label.setBounds(56, 64, 245, 38);
		frame.getContentPane().add(complaint_label);
		
		creditpoint_label = new JLabel("<---What is my credit point?");
		creditpoint_label.setForeground(new Color(0, 128, 0));
		creditpoint_label.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		creditpoint_label.setBounds(276, 169, 315, 37);
		frame.getContentPane().add(creditpoint_label);
		
	    status_label = new JLabel("Track my Complaint's status-->");
		status_label.setForeground(new Color(255, 165, 0));
		status_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		status_label.setBounds(12, 279, 323, 38);
		frame.getContentPane().add(status_label);
		
	      
		 background =new JLabel(new ImageIcon("source\\bg4.jpg"));
	  	 background.setBounds(0,0, 585, 450);
	     frame.add(background);

		
		frame.setVisible(true);
	}
        
}