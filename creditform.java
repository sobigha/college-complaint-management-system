package project;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class creditform {
    
	JFrame frame;
	JTextField credit_textfield;
	JLabel credit_label,background;
	
    creditform(String credits)
    {
		frame = new JFrame();
		frame.setTitle("CREDITS");
		frame.setBounds(600, 300, 577, 425);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel credit_label = new JLabel("You Have Earned ");
		credit_label.setFont(new Font("Yu Gothic", Font.BOLD, 27));
		credit_label.setForeground(new Color(0, 128, 0));
		credit_label.setBounds(156, 63, 258, 90);
		frame.getContentPane().add(credit_label);
		
		credit_textfield = new JTextField();
		credit_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 27));
		credit_textfield.setEditable(false);
		credit_textfield.setBounds(214, 184, 116, 30);
		frame.getContentPane().add(credit_textfield);
		credit_textfield.setText(credits);
		credit_textfield.setHorizontalAlignment(JTextField.CENTER);
		
		 background =new JLabel(new ImageIcon("source\\image9.jpg"));
	  	 background.setBounds(-100, -100, 800, 800);
	     frame.add(background);

		frame.setVisible(true);
	}

}