

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class resetpass
 */
@WebServlet("/resetpass")
public class resetpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 int  otpgenc=(int) (Math.random()*9000)+1000;
    public resetpass() {
        super();
        // TODO Auto-generated constructor stub
     
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		
		
		try {
			String url="jdbc:mysql://localhost:3306/bs";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, "root", "");
			
			String action=request.getParameter("action");
			
			   if("generate_otp".equals(action)) {
						 out.println("<table border='1'><tr><th>OTP</th>");
							out.print("<tr><td>");
							out.println("Your otp is");
							out.println(otpgenc);
							out.print("</td>");
							out.print("</tr>");
						
			   }
			if("change".equals(action))
			{
		
		
			int otp=Integer.parseInt(request.getParameter("otp"));
			System.out.println(otp);
			System.out.println("final otp gen"+otpgenc);
			String uname=request.getParameter("uname");
			
			if(otpgenc==otp)
			{
				final String corgstr=request.getParameter("newpass");
				
				 String fpass = Base64.getEncoder().encodeToString(corgstr.getBytes("UTF-8"));
				 PreparedStatement st=con.prepareStatement("update user_reg set pass='"+fpass+"',cpass='"+fpass+"' where uname='"+uname+"'");
					//Statement st=con.createStatement();
					int count=0;
				    count= st.executeUpdate();
			
			
			if(count==1) {
				response.sendRedirect("login.jsp");
			}
			else
			{
				out.print("Something went wrong!!!");
			}
			}
			else
			{
				out.print("Wrong otp");
			}
			}

		
		
		   
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		out.print("</table>");
	}

}
