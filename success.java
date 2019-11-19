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
 * Servlet implementation class success
 */
public class success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public success() {
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
		try{
		response.setContentType("text/html");
		Statement stmt=con.createStatement();
        ResultSet rs2=stmt.executeQuery("select * from user_reg");
          
          
          PrintWriter out=response.getWriter();
          out.println("<html><head>");
          out.println("<body><center><table border='1'>");
          out.println("<u><font color='green'><h1>All User Data</h1></font></u>");
          out.println("<tr><th>Serial Number</th><th>Name</th><th>Age</th><th>Religion</th><th>Mother Tongue</th><th>Other Language</th><th>Literacy Status</th><th>Country Name</th><th>District</th><th>Village/Town</th><th>Aadhar No.</th></tr>");

          while(rs2.next()){
          	out.println("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getInt(3)+"</td><td>"+rs2.getString(4)+"</td><td>"+rs2.getString(5)+"</td><td>"+rs2.getString(6)+"</td><td>"+rs2.getString(7)+"</td><td>"+rs2.getString(8)+"</td><td>"+rs2.getString(9)+"</td><td>"+rs2.getString(10)+"</td><td>"+rs2.getString(11)+"</td></tr>");
          }
          out.println("</center>");
          out.println("<h3 align='right'><a href='index.html'>Log Out</a></h3>");
          out.println("<h3 align='right'><a href='modify.html'>Modify</a></h3>");
          /*out.println("<h3 align='right'><a href='m_serialno.html' role='button' class='btn'>Modify Serial Number</a></h3>");
          out.println("<h3 align='right'><a href='m_firstname.html'>Modify Name</a></h3>");
          out.println("<h3 align='right'><a href='m_age.html'>Modify Age</a></h3>");
          out.println("<h3 align='right'><a href='m_religion.html'>Modify Religion</a></h3>");
          out.println("<h3 align='right'><a href='m_mtongue.html'>Modify Mother Tongue</a></h3>");
          out.println("<h3 align='right'><a href='m_lstatus.html'>Modify Literacy Status</a></h3>");
          out.println("<h3 align='right'><a href='m_village.html'>Modify Mother Village/Town</a></h3>");
          out.println("<h3 align='right'><a href='verify.html'>Modify District</a></h3>");*/
          out.println("<h3 align='right'><a href='delete.html'>Delete Record</a></h3>");
          
          out.println("</table></body></html>");
		}
		 catch(Exception e){
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
