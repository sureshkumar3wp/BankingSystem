

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request
 */
@WebServlet("/Request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Request() {
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
		
        int accno=Integer.parseInt(request.getParameter("accno"));
		String fname=request.getParameter("fname");
		String email=request.getParameter("email");
		
		String address=request.getParameter("address");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String  mobile=request.getParameter("mobile");
		try {
			String url="jdbc:mysql://localhost:3306/bs";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, "root", "");
			PreparedStatement st=con.prepareStatement("insert into rtemplate(accno,name,email,address,country,state,city,mobile)values('"+accno+"','"+fname+"','"+email+"','"+address+"','"+country+"','"+state+"','"+city+"','"+mobile+"')");
			//Statement st=con.createStatement();
			int count=0;
		    count= st.executeUpdate();
		    
		
			if((count==1))
			{
				
				System.out.println("Successfully applied");
				response.sendRedirect("welcome.jsp");
			}
			else
			{
				System.out.println("Something went wrong Please try again!!!");
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

}
