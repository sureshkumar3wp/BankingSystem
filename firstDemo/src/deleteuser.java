

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteuser
 */
@WebServlet("/deleteuser")
public class deleteuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteuser() {
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
		PrintWriter out =response.getWriter();
		String uname= request.getParameter("uname");
		    try
		    {
		    	String url="jdbc:mysql://localhost:3306/mydb";
		    	  Class.forName("com.mysql.jdbc.Driver");
				    Connection con=DriverManager.getConnection(url, "root", "");
				    PreparedStatement st= con.prepareStatement("Delete from user_reg where uname ='"+uname+"'");
				    int n=st.executeUpdate();
				    if(n==1)
				    {
				    	response.sendRedirect("login.jsp");
				    }
				    else
				    {
				    	out.println("your account is not deleted");
				    }
		    }catch(Exception e)
		    {
		    	System.out.println(e);
		    }
		  
	}

}
