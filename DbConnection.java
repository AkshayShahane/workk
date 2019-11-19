package mini_project1;
import java.sql.*;
import java.util.*;
public class DbConnection {

	static Connection con=null;
	public static Connection connect()
	{
		 try
	        {												//class is Class Name 
	         if(con==null)
	         	{
					 Class.forName("com.mysql.jdbc.Driver");		//Load The Drivers (forName is Method)
			            System.out.println("Driver Loaded..");
		
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/min_project","root","");
			            System.out.println("Connection Established..");
	         	}
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
		 return con;
	}
	
}
