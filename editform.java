package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;


public class editform {
	 JFrame frame;
	 JLabel victim_label,roll_label,dept_label,time_label,reason_label,place_label,section_label,year_label,remarks_label;
	 JTextField name_textfield,roll_textfield,timing_textfield;
	 JTextArea reason_textarea,remarks_textarea;
	 JButton  submit_button,clear_button;
	 int[] seq= {4,5,3,8,9,1,2,6,7};
	 sqlconnect sql;
	 String queryString; 
	 PreparedStatement p ;
	 ResultSet rs;
	 Statement stmt;
	 
	public editform(Integer sno, JTable table, String email) {
		frame = new JFrame();
		frame.setTitle("Complaint Form");
		frame.setBounds(500, 100, 782, 778);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		victim_label = new JLabel("Suspect Name");
		victim_label .setFont(new Font("Yu Gothic", Font.BOLD, 21));
		victim_label .setBounds(98, 117, 157, 31);
		frame.getContentPane().add(victim_label );
		
	    roll_label = new JLabel("Roll Number");
	    roll_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
	    roll_label.setBounds(102, 191, 153, 31);
		frame.getContentPane().add(roll_label);
		
		dept_label = new JLabel("Department");
		dept_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		dept_label.setBounds(107, 255, 140, 31);
		frame.getContentPane().add(dept_label);
		
		time_label = new JLabel("Timing");
		time_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		time_label.setBounds(141, 452, 106, 31);
		frame.getContentPane().add(time_label);
		
		reason_label = new JLabel("Reason");
		reason_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		reason_label.setBounds(141, 510, 76, 31);
		frame.getContentPane().add(reason_label);
		
		remarks_label = new JLabel("Remarks");
		remarks_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		remarks_label.setBounds(130, 580, 100, 31);
		frame.getContentPane().add(remarks_label);
		
		place_label = new JLabel("Place");
		place_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		place_label.setBounds(141, 387, 76, 31);
		frame.getContentPane().add(place_label );
		
	    section_label = new JLabel("Section");
		section_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		section_label.setBounds(406, 330, 82, 31);
		frame.getContentPane().add(section_label );
		
		year_label = new JLabel("Year");
		year_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		year_label.setBounds(141, 327, 76, 31);
		frame.getContentPane().add(year_label );
			
		name_textfield = new JTextField();
		name_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		name_textfield.setBounds(297, 117, 277, 34);
		frame.getContentPane().add(name_textfield);
				
		roll_textfield = new JTextField();
		roll_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		roll_textfield.setBounds(297, 189, 277, 34);
		frame.getContentPane().add(roll_textfield);
				
		SpinnerDateModel model1=new SpinnerDateModel();
		model1.setCalendarField(Calendar.HOUR);
		JSpinner startTime=new JSpinner();
		startTime.setModel(model1);
		startTime.setBounds(297, 455, 277, 34);
		startTime.setEditor(new JSpinner.DateEditor(startTime,"yyyy-MM-dd"));
		JFormattedTextField tf= ((JSpinner.DefaultEditor)startTime.getEditor()).getTextField();
	   	tf.setEditable(false);
	   	frame.getContentPane().add(startTime);
	   	
		 JComboBox<String> dept_combobox= new JComboBox<String>();
		 dept_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		 dept_combobox.setBounds(297, 258, 116, 25);
		 dept_combobox.addItem("CSE");
		 dept_combobox.addItem("IT");
		 dept_combobox.addItem("EEE");
		 dept_combobox.addItem("ECE");
		 dept_combobox.addItem("MECH");
		 dept_combobox.addItem("MCT");
		 dept_combobox.addItem("CIVIL");
		 frame.getContentPane().add(dept_combobox);
		
	     JComboBox<String> year_combobox= new JComboBox<String>();
		 year_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		 year_combobox.setBounds(297, 333, 76, 25);
		 year_combobox.addItem("1");
		 year_combobox.addItem("2");
		 year_combobox.addItem("3");
		 year_combobox.addItem("4");
		 frame.getContentPane().add(year_combobox);
		
		 JComboBox<String> section_combobox= new JComboBox<String>();
		 section_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		 section_combobox.setBounds(500, 330, 66, 25);
		 section_combobox.addItem("A");
		 section_combobox.addItem("B");
		 section_combobox.addItem("C");
		 frame.getContentPane().add(section_combobox);
		
		 JComboBox<String> place_combobox= new JComboBox<String>();
		 place_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		 place_combobox.setBounds(297, 390, 150, 25);
		 place_combobox.addItem("C1 Block");
		 place_combobox.addItem("C2 Block");
		 place_combobox.addItem("C3 Block");
		 place_combobox.addItem("C4 Block");
		 place_combobox.addItem("C5 Block");
		 place_combobox.addItem("Library");
		 place_combobox.addItem("0/100");
		 place_combobox.addItem("Mexitos");
		 place_combobox.addItem("Convention center");
		 place_combobox.addItem("Krishna Hall");
		 place_combobox.addItem("Food Court");
		 frame.getContentPane().add(place_combobox);
		
		reason_textarea = new JTextArea();
		reason_textarea.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		reason_textarea.setBounds(297, 507, 280, 50);	
		frame.getContentPane().add(reason_textarea);
		
		remarks_textarea = new JTextArea();
		remarks_textarea.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		remarks_textarea.setBounds(297, 575, 280, 50);	
		frame.getContentPane().add(remarks_textarea);

	    submit_button = new JButton("Submit");
	    submit_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] formvalue = new String[9];
				try {
				//{4,5,3,8,9,1,2,6,7}
				formvalue[0]=name_textfield.getText().toString();
				formvalue[1]=roll_textfield.getText().toString();
				formvalue[2]=dept_combobox.getSelectedItem().toString();
				formvalue[3]=year_combobox.getSelectedItem().toString();
				formvalue[4]=section_combobox.getSelectedItem().toString();
				formvalue[5]=place_combobox.getSelectedItem().toString();
				formvalue[6]=tf.getText();
				formvalue[7]=reason_textarea.getText().toString();
				formvalue[8]=remarks_textarea.getText().toString();
				int flag=0;
				for(int i=0;i<=8;i++) {
					//check for Changed value
					if(rs.getString(seq[i])==null || rs.getString(seq[i]).equals(formvalue[i])==false) {
						
						queryString = "UPDATE Db.complain SET "+rs.getMetaData().getColumnName(seq[i])+"=? WHERE SNO = ?";
						
						p=sql.con.prepareStatement(queryString);
						if(i!=6)
							p.setString(1, formvalue[i]);
						else 
							//"TO_DATE('"+formvalue[i]+"','YYYY-MM-DD')";
							p.setDate(1, Date.valueOf(formvalue[i]));
						
						p.setInt(2, sno);
						p.executeQuery();
						if(flag==0) {
						JOptionPane.showMessageDialog(null, "Update Successfully");
						flag=1;
						}
					}
				}
			   DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			   dtm.setRowCount(0);
				
			   sql=new sqlconnect();
	    	   stmt=sql.con.createStatement();
	    	   if(email!="root") {
		    	   rs = stmt.executeQuery("select * from Db.advisor where EMAIL='"+email+"'");
		    	   rs.next();
		    	   rs=stmt.executeQuery("select * from Db.complain where section = '"+rs.getString("CLASS")+"' and department='"+rs.getString("DEPARTMENT")+"'");
	    	   }else {
		    	   rs=stmt.executeQuery("select * from Db.complain");
	    	   }
	    	   while(rs.next())
	    	   {
	    		   int sno = rs.getInt("sno");
	    		   String victim_name = rs.getString("VICTIM_NAME")  ;
	    		   String rollnumber = rs.getString("REGNO")  ;
	    		   String department =rs.getString("DEPARTMENT") ;
	    		   String year = rs.getString("YEAR") ;
	    		   String section = rs.getString("SECTION") ; 
	    		   String place = rs.getString("PLACE") ;
	    		   Date timing = rs.getDate("TIME") ;
	    		   String reason = rs.getString("REASON") ;   
	    		   String remarks = rs.getString("REMARK") ;
	    		   dtm.addRow(new Object[]{sno,victim_name,rollnumber,department,year,section,place,timing,reason,remarks});  	    		   
	    		   //table.setModel((TableModel) model); 	    		   
	    	   }
	    	   frame.setVisible(false);
		       }
				catch (Exception e1) {
					System.out.println(e1);
				}				
		}
		});
	    submit_button .setFont(new Font("Yu Gothic", Font.BOLD, 21));
	    submit_button .setBounds(235, 654, 131, 34);
		frame.getContentPane().add(submit_button);
		
		clear_button = new JButton("Clear");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cl) {
				
				name_textfield.setText("");
				roll_textfield.setText("");
				reason_textarea.setText("");
				
				JOptionPane.showMessageDialog(null, "Cleared Successfully");
			}
		});
		clear_button.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		clear_button.setBounds(406, 654, 131, 34);
		frame.getContentPane().add(clear_button);
			
		JLabel backgroundJLabel = new JLabel(new ImageIcon("source\\bg3.jpg")); //\\src\\project
        backgroundJLabel.setBounds(0,0, 782, 778);
        frame.add(backgroundJLabel);
        
		frame.setVisible(true);

		try {
		   sql=new sqlconnect();
	 	   queryString = "Select * from Db.complain where sno=?";
	 	   p = sql.con.prepareStatement(queryString);
	 	   p.setInt(1, sno);
	 	   rs = p.executeQuery();
	 	   rs.next();
	 	   
          name_textfield.setText(rs.getString(seq[0]));
          roll_textfield.setText(rs.getString(seq[1]));
          dept_combobox.setSelectedItem(rs.getString(seq[2]));
          year_combobox.setSelectedItem(rs.getString(seq[3]));
          section_combobox.setSelectedItem(rs.getString(seq[4]));
          place_combobox.setSelectedItem(rs.getString(seq[5]));
          tf.setValue(rs.getDate(seq[6]));
          reason_textarea.setText(rs.getString(seq[7]));
          remarks_textarea.setText(rs.getString(seq[8]));
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
