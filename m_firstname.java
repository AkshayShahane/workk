package mini_project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class m_firstname
 */
public class m_firstname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public m_firstname() {
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
		String name=request.getParameter("name");
		
		
		
		try{
            response.setContentType("text/html");
           
			
			PreparedStatement pstmt=con.prepareStatement("update user_reg set Name=? where Aadhar_Card_No=?");
			pstmt.setString(1,name);
			pstmt.setLong(2,adhar);
			
			int i=pstmt.executeUpdate();
			Statement stmt=con.createStatement();
	          //ResultSet rs=stmt.executeQuery("select * from user_reg");
	            
	            
	            PrintWriter out=response.getWriter();
	            out.println("<html><head><style>.btn{color: black;background-color:aqua;text-decoration: none;padding: 25px 50px;font-size: 20px;border-radius: 10px;}</style><body><center>");
	            out.println("<font color='green'><h1><b><u>Update Successfull....</u></b></h1></font><br><br><br><br>");
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
