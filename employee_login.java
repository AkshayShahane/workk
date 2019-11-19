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
 * Servlet implementation class employee_login
 */
public class employee_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employee_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username=request.getParameter("emp_name");
		String password=request.getParameter("emp_password");
		String pw=null;
		
		Connection con=DbConnection.connect();
		
		try{
			
			PreparedStatement pstmt=con.prepareStatement("select * from emp where Username=? and Password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			//int i=pstmt.executeUpdate();*/
			
			//Statement stmt=con.createStatement(); //statement is interfaces (return the table)
            ResultSet rs=pstmt.executeQuery();//to create statement obj (i.e rs)
            while(rs.next()){
               	pw=rs.getString(10);
               	//un=rs.getString(9);
            	if(pw.equals(password)){
            		System.out.println("Login success");
            		response.sendRedirect("success.html");
            		 
                     
            	}
            	else if(pw!=password.intern()){
            		System.out.println("Sorry!!!Login Fail...");
            		response.sendRedirect("fail_page.html");
            	}
            	
            }
        
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
