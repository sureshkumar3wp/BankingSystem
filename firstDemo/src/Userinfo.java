

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
 * Servlet implementation class Userinfo
 */
@WebServlet("/Userinfo")
public class Userinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<h3>Display the record</h3>");
		int accno=Integer.parseInt(request.getParameter("name"));
		out.println("<table border='1'><tr><th>fname</th><th>email</th><th>dob</th><th>age</th><th>gender</th><th>address</th><th>country</th><th>state</th><th>city</th><th>mobile</th>");
		
		try {
			String url="jdbc:mysql://localhost:3306/bs";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, "root", "");
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select fname,email,dob,age,gender,address,country,state,city,mobile from user_reg where accno='"+accno+"'");
			
			if(rs.next()) {
				out.print("<tr><td>");
				out.println(rs.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(4));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(5));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(6));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(7));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(8));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(9));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(10));
				out.print("</td>");
				out.print("</tr>");
			}
			else
			{
				out.println("Wrong credentials");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		out.print("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
