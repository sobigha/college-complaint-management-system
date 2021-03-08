package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewregistration {
	JFrame frame;
	   JTable table;
	   JLabel view_label;
	   JScrollPane scroll;
	   DefaultTableModel model;
	   sqlconnect sql;
	   Statement stmt;
	   ResultSet rs;
	   ArrayList<String> reg = new ArrayList<String>();

	   @SuppressWarnings("serial")
	   viewregistration(){
					
		       frame = new JFrame("View all Registration");
		       frame.setBounds(400, 100, 1180, 800);
		       frame.setLayout(null);
		       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		       frame.setResizable(false);
		       
		       view_label=new JLabel(" View all Registration");
		       view_label.setBounds(500, 10,350, 50);
		       view_label.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		       frame.getContentPane().add(view_label);
		       
		       JButton edit_button = new JButton("Edit");
		       edit_button.setBounds(50, 625, 100, 30);
		       edit_button.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		       frame.getContentPane().add(edit_button);
		       edit_button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new studentForm(reg.get(table.getSelectedRow()),table);
				}
			});
		
	           table=new JTable(6,6) { 
		       public boolean isCellEditable(int row,int columns) {
	                   return false;
	               }};
	               
		       model = new DefaultTableModel(new String[]{"FIRST_NAME","LAST_NAME","REGNO","EMAIL","PHONENUMBER","GENDER","DEPARTMENT","YEAR","SECTION","CREDIT_POINT"},0);	            
		       table.setRowHeight(60);	
	    
		       scroll = new JScrollPane(table);
		       scroll.setBounds(50, 70, 1080, 550);
	  	       scroll.setWheelScrollingEnabled(true);
		       frame.getContentPane().add(scroll); 
	    
		       try {
			    	 sql=new sqlconnect();
			    	 int[] seq= {8,9,1,2,3,10,4,5,7,13};
			    	 stmt=sql.con.createStatement();
			    	 rs=stmt.executeQuery("select * from Db.student");
					 while(rs.next())
					  {
						reg.add(rs.getString(1));
						ArrayList<Object> row = new ArrayList<Object>();
						for(int col=0;col<seq.length;col++) {
							row.add(rs.getObject(seq[col]));
						}
					    model.addRow(row.toArray());
					    table.setModel(model);
					  }
					 }
					 catch(Exception e) {
						 JOptionPane.showMessageDialog(null, e.toString()); 
					
					 }

		       frame.setVisible(true);	 
	       }
}
