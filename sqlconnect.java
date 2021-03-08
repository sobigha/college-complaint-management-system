package project;
import java.sql.*;
public class sqlconnect {
	Connection con;
	public sqlconnect() throws ClassNotFoundException,SQLException{
		//Loaded Oracle Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Connection Object
		this.con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	}
	void connect() {
		try {
			//Statement Object
			Statement stmt=this.con.createStatement();
			
			//resultset for storing query
			ResultSet rs=stmt.executeQuery("select * from Db.student");
			System.out.println(rs.next());
			//closing connection and statement object
			stmt.close();
			con.close();
		}catch(Exception e) {
			if(e instanceof ClassNotFoundException) {
				System.out.println("Class Not Found");
			}
			else if (e instanceof SQLException) {
				System.out.println("Sql Exeception");
			}
		}
	}
	
}
