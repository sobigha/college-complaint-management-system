package project;

import java.awt.Font;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class statusform {
	
   JFrame frame;
   JTable table;
   JLabel view_label;
   JScrollPane scroll;
   DefaultTableModel model;
   sqlconnect sql;
   Statement stmt;
   ResultSet rs;

   @SuppressWarnings("serial")
   statusform(String regno){
				
	       frame = new JFrame("View My Status");
	       frame.setBounds(400, 100, 1180, 800);
	       frame.setLayout(null);
	       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	       frame.setResizable(false);
	       
	       view_label=new JLabel(" Current Status of the Complaint");
	       view_label.setBounds(500, 10,350, 50);
	       view_label.setFont(new Font("Yu Gothic", Font.BOLD, 20));
	       frame.getContentPane().add(view_label);
	
           table=new JTable(6,6) { 
	       public boolean isCellEditable(int row,int columns) {
                   return false;
               }};
               
	       model = new DefaultTableModel(new String[]{"SUSPECT NAME","Suspect Regno","PLACE","TIMING","REASON","CURRENT STATUS"},0);	            
	       table.setRowHeight(60);	
    
	       scroll = new JScrollPane(table);
	       scroll.setBounds(50, 70, 1080, 550);
  	       scroll.setWheelScrollingEnabled(true);
	       frame.getContentPane().add(scroll); 
    
	       try {
		    	 sql=new sqlconnect();
		    	 stmt=sql.con.createStatement();
		    	 rs=stmt.executeQuery("select * from Db.complain where REGNO='"+regno.toLowerCase()+"'");
				 while(rs.next())
				  {
				   String victim_name = rs.getString("VICTIM_NAME")  ;
	    		   String rollnumber = rs.getString("REGNO")  ;
	    		   String place = rs.getString("PLACE") ;
	    		   Date timing = rs.getDate("TIME") ;
	    		   String reason = rs.getString("REASON") ;   
	    		   String remarks = rs.getString("REMARK") ; 
	    		   String status;
	    		   
	    		   if(remarks== null || remarks=="")
	    			   status = "Pending";
	    		   else
	    			   status="Completed";
	    		   
				    model.addRow(new Object[]{victim_name,rollnumber,place,timing,reason,status});
				    table.setModel(model);
				  }
				 }
				 catch(Exception e) {
					 JOptionPane.showMessageDialog(null, e.toString()); 
				
				 }

	       frame.setVisible(true);	 
       }
}