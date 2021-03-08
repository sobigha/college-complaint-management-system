package project;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_dashboard {
	JFrame frame;
	JSeparator separator;
	JButton registration_button,complaint_button;
	JLabel register_label, complaint_label,background;

	admin_dashboard()
	{
		frame = new JFrame("Admin Dashboard");
		frame.setBounds(600, 300, 585, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
	    separator = new JSeparator();
		separator.setBounds(67, 194, 427, 15);
		frame.getContentPane().add(separator);
		
		registration_button = new JButton("View Registrations");
		registration_button.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		registration_button.setBounds(310, 97, 159, 35);
		frame.getContentPane().add(registration_button);
		registration_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new viewregistration();
				
			}
		});
		
		complaint_button = new JButton("View Complaints");
		complaint_button.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		complaint_button.setBounds(83, 264, 150, 38);
		frame.getContentPane().add(complaint_button);
		complaint_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new viewform();
			}
		});
		
		register_label = new JLabel("View all Registrations-->");
		register_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		register_label.setForeground(new Color(0, 128, 0));
		register_label.setBounds(28, 97, 280, 48);
		frame.getContentPane().add(register_label);
		
	    complaint_label = new JLabel("   <--View all Complaints");
		complaint_label.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		complaint_label.setForeground(new Color(128, 0, 128));
		complaint_label.setBounds(263, 257, 264, 45);
		frame.getContentPane().add(complaint_label);
				   
	 	 background =new JLabel(new ImageIcon("source\\bg4.jpg"));
	  	 background.setBounds(0,0, 585, 450);
	     frame.add(background);
		
		frame.setVisible(true);
	}
}
