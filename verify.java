package mini_project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class verify
 */
public class verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection con=DbConnection.connect();
		System.out.print("Hello");
		
		long adhar=Long.parseLong(request.getParameter("aadhar"));
		String dist=request.getParameter("dist");
		
		
		
		try{
            response.setContentType("text/html");
           
			
			PreparedStatement pstmt=con.prepareStatement("update user_reg set District=? where Aadhar_Card_No=?");
			pstmt.setString(1,dist);
			pstmt.setLong(2,adhar);
			
			int i=pstmt.executeUpdate();//to create statement obj (i.e rs)
			//PrintWriter out=response.getWriter();
			/*if(s_name=="aadhar"){
				out.println("<html><body><center><form method='get' action='Update'");
				out.println("Enter New Aadhar No:<input type='text' name='serial'>");
				out.println("<input type='submit' name='submit' value='Submit'>");
				out.println("</form></center></body></html>");
			}*/  
			
			/*PrintWriter out=response.getWriter();
			out.println("<html><body><center><table border='1'>");
            out.println("<h1><u>Person Verification</u></h1>");
            out.println("<tr><th>Serial Number</th><th>Name</th><th>Age</th><th>Religion</th><th>Mother Tongue</th><th>Other Language</th><th>Literacy Status</th><th>Country Name</th><th>District</th><th>Village/Town</th><th>Aadhar No.</th></tr>");
            while(rs.next()){
               	//ser=rs.getInt(1);
            	//if(ser!=serial_no){
              	out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td></tr>");

            		
            	/*}
            	else
            	{
            		
            		System.out.println("Sorry!!!Record Not Found...");
            		response.sendRedirect("fail_page.html");
            	}*/
            //}
            
            /*Statement stmt=con.createStatement();
            ResultSet rs2=stmt.executeQuery("select * from user_reg");*/
              
              
              
              

              //while(rs2.next()){
              //}
              /*out.println("</table></center></body></html>");
              System.out.println("Record Found...");
      		response.sendRedirect("congo.html");*/
			
			Statement stmt=con.createStatement();
	          //ResultSet rs=stmt.executeQuery("select * from user_reg");
	            
	            
	            PrintWriter out=response.getWriter();
	            out.println("<html><head><style>.btn{color: black;background-color:aqua;text-decoration: none;padding: 25px 50px;font-size: 20px;border-radius: 10px;}</style><body><center>");
	            out.println("<font color='green'><h1><b><u>Record Updated Successfull....</u></b></h1></font><br><br><br><br>");
	            out.println("<h1><a href='modify.html' role='button' class='btn'>Back</a></h1>");
	            out.println("</center></body></html>");
			
	} catch(Exception e){
		System.out.println(e);
	}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
