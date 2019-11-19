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
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		
		int serial1=Integer.parseInt(request.getParameter("serial"));
		int aadhar=Aadhar.getAadhar();
		
		try{
			
			response.setContentType("text/html");
			
			PreparedStatement pstmt=con.prepareStatement("update user_reg set Serial_No=? where Aadhar_Card_No=?");
			pstmt.setInt(1,serial1);
			pstmt.setInt(2,aadhar);
			int i=pstmt.executeUpdate();
			
			Statement stmt=con.createStatement();
	          //ResultSet rs=stmt.executeQuery("select * from user_reg");
	            
	            
	            PrintWriter out=response.getWriter();
	            out.println("<html><body><center>");
	            out.println("<h1><b>Update Successfull....</b></h1>");
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
