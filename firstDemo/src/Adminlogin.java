

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminlogin() {
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
		String pass= request.getParameter("pass");
		
		
		try {
			String url="jdbc:mysql://localhost:3306/bs";
			String query="select uname,upass from user_reg where uname="+name+"and upass="+pass;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, "root", "");
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select aname,pass from ad_reg where aname='"+name+"'and pass='"+pass+"'");
			
			PrintWriter out=response.getWriter();
			
			if(rs.next()) {
				
				HttpSession session= request.getSession();
				session.setAttribute("name", name);
				response.sendRedirect("adminhome.jsp");
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
