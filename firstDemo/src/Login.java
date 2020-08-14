

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String name = request.getParameter("name");
		final String orgstr= request.getParameter("pass");
		String pass= Base64.getEncoder().encodeToString(orgstr.getBytes("UTF-8"));
		
		try {
			String url="jdbc:mysql://localhost:3306/bs";
			String query="select uname,upass from user_reg where uname="+name+"and upass="+pass;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, "root", "");
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select uname,pass,accno from user_reg where uname='"+name+"'and pass='"+pass+"'");
			
			
			
			
			PrintWriter out=response.getWriter();
			
			if(rs.next()) {
				try {
					int accgen=rs.getInt(3);
					HttpSession session= request.getSession();
					session.setAttribute("accno", accgen);
					session.setAttribute("names", name);
					
					//response.sendRedirect("welcome.jsp?accno="+accgen);
					response.sendRedirect("welcome.jsp");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
			else
			{
				out.println("Wrong credentials");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		
	}

}
