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
 * Servlet implementation class user_reg
 */
public class user_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_reg() {
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

		int s_no=Integer.parseInt(request.getParameter("serial_no"));
		String s_name=request.getParameter("sname");
		int age=Integer.parseInt(request.getParameter("age"));
		
		//Date b_date=Date.parseDate(request.getParameter("b_date"));
		String religion=request.getParameter("religion");
		 //mob_no=Integer.parseInt(request.getParameter("user_mob"));
		String mother_tongue=request.getParameter("mother_t");
		String other_lang=request.getParameter("o_lang");
		//String b_date1=request.getParameter("b_date");
		String literacy=request.getParameter("literacy");
		String c_name=request.getParameter("c_name");
		String district=request.getParameter("district");
		String village=request.getParameter("village");
		long aadhar=Long.parseLong(request.getParameter("aadhar_no"));
		//String address=request.getParameter("address");
		//System.out.print("we got; "+ f_name + l_name + email + b_place + address + nationality + designation );
		try{
            response.setContentType("text/html");
           
			
			PreparedStatement pstmt=con.prepareStatement("insert into user_reg values(?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1,s_no);
            pstmt.setString(2,s_name);
            //pstmt.setInt(2, licence_no);
            pstmt.setInt(3,age);
            pstmt.setString(4,religion);
            pstmt.setString(5,mother_tongue);
           pstmt.setString(6,other_lang);
           pstmt.setString(7,literacy);
           pstmt.setString(8,c_name);
           pstmt.setString(9,district);
           pstmt.setString(10,village);
           pstmt.setLong(11,aadhar);
           //pstmt.setString(12,address);
   		System.out.print("Hello");

			//pstmt.setDate(6,b_date); //set Date to PrepatedStatement    
            
            int j=pstmt.executeUpdate();
            System.out.println(j+" record(s) inserted");
            
            Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery("select * from user_reg");
            
            
            PrintWriter out=response.getWriter();
            out.println("<html><body><center><table border='1'>");
            out.println("<h1><b>All Users Data</b></h1>");
            out.println("<tr><th>Serial No.</th><th>Name</th><th>Age</th><th>Religion</th><th>Mother Tongue</th><th>Other Language</th><th>Literacy Status</th><th>Country</th><th>District</th><th>Village/Town</th><th>Aadhar Card No</th></tr>");
            while(rs.next()){
            	out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getLong(11)+"</td></tr>");
            	
            }
            out.println("<h4><b>Congratulations!!!Your Data is Added To our Server</b></h4>");
            out.println("</table></center></body></html>");
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
