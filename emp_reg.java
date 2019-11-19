package mini_project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class emp_reg
 */
public class emp_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emp_reg() {
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

		String f_name=request.getParameter("first_name");
		String l_name=request.getParameter("last_name");
		long mob_no=Long.parseLong(request.getParameter("mob_no"));
		
		//Date b_date=Date.parseDate(request.getParameter("b_date"));
		String email=request.getParameter("user_email");
		 //mob_no=Integer.parseInt(request.getParameter("user_mob"));
		String b_place=request.getParameter("birth_place");
		String address=request.getParameter("address");
		//String b_date1=request.getParameter("b_date");
		String nationality=request.getParameter("nationality");
		String designation=request.getParameter("designation");
		String emp_username=request.getParameter("emp_username");
		String emp_password=request.getParameter("emp_password");
		System.out.print("we got; "+ f_name + l_name + email + b_place + address + nationality + designation );
		try{
            response.setContentType("text/html");
           
			
			PreparedStatement pstmt=con.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1,f_name);
            pstmt.setString(2,l_name);
            //pstmt.setInt(2, licence_no);
            pstmt.setLong(3,mob_no);
            pstmt.setString(4,email);
            pstmt.setString(5,b_place);
           pstmt.setString(6,address);
           pstmt.setString(7,nationality);
           pstmt.setString(8,designation);
           pstmt.setString(9,emp_username);
           pstmt.setString(10,emp_password);
   		System.out.print("Hello");

			//pstmt.setDate(6,b_date); //set Date to PrepatedStatement    
            
            int j=pstmt.executeUpdate();
            System.out.println(j+" record(s) inserted");
            
            Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery("select * from emp");
            
            
            PrintWriter out=response.getWriter();
            out.println("<html><body><center><table border='1'>");
            out.println("<u><font color='green'><h1>Employee Added Successfully!!!</h1></font></u>");
            out.println("<h1><u>All Employee Details</u></h1>");
            out.println("<tr><th>First Name</th><th>Last Name</th><th>Mobile No</th><th>E-Mail</th><th>	Birthplace</th><th>Address</th><th>Nationality</th><th>Designation</th><th>Username</th><th>Password</th></tr>");
            while(rs.next()){
            	out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getLong(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td></tr>");
            }
            out.println("</center>");
            out.println("<h4><a href='index.html'>Log Out</a></h4>");
            out.println("</table></body></html>");
            //con.close();
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
