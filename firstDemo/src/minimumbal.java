

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class minimumbal
 */
@WebServlet("/minimumbal")
public class minimumbal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public minimumbal() {
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
			Statement st= con.createStatement();
			String action=request.getParameter("action");
			if("minimum_balance".equals(action))
			{
		
			out.println("<h3>Customers are less than the minimum balance</h3>");
			int amount=Integer.parseInt(request.getParameter("amnt"));
			out.println("<table border='1'><tr><th>Name</th><th>accno</th>");
			
			ResultSet rs=st.executeQuery("select name,accno from balance where amount<='"+amount+"'");
			
			while(rs.next()) {
				out.print("<tr><td>");
				out.println(rs.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(2));
				out.print("</td>");
				out.print("</tr>");
			}
			}
		   if("maximum_spend".equals(action)) {
				
			   out.println("<h3>Customer spend maximum </h3>");
				out.println("<table border='1'><tr><th>accno</th><th>amount</th><th>transid</th><th>retailername</th><th>date");
				
				ResultSet rs=st.executeQuery("select accno,max(debit) ,transid,retailername,datet from transaction where (retailername) != 'not null'");
				
				while(rs.next()) {
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
					out.println(rs.getString(4));
					out.print("</td>");
					out.print("<td>");
					out.println(rs.getString(5));
					out.print("</td>");
					out.print("</tr>");
				}
				
			}
		   if("minimum_spend".equals(action)) {
				
			   out.println("<h3>Customer spend minimum </h3>");
				out.println("<table border='1'><tr><th>accno</th><th>amount</th><th>transid</th><th>retailername</th><th>date");
				
				ResultSet rs=st.executeQuery("select accno,min(debit) ,transid,retailername,datet from transaction where (retailername) != 'not null'");
				
				while(rs.next()) {
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
					out.println(rs.getString(4));
					out.print("</td>");
					out.print("<td>");
					out.println(rs.getString(5));
					out.print("</td>");
					out.print("</tr>");
				}
				
			}
		   
		   if("maximum_spend_day".equals(action)) {
			   
			  // int date=Integer.parseInt(request.getParameter("max_spend_d"));
			   String date=request.getParameter("max_spend_d");
			   out.println("<h3>Customer spend maximum of single day </h3>");
				out.println("<table border='1'><tr><th>accno</th><th>amount</th><th>transid</th><th>retailername</th><th>date");
				
				ResultSet rs=st.executeQuery("select accno,max(debit) ,transid,retailername,datet from transaction where (retailername) != 'not null' and (datet) ='"+date+"'");
				
				while(rs.next()) {
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
					out.println(rs.getString(4));
					out.print("</td>");
					out.print("<td>");
					out.println(rs.getString(5));
					out.print("</td>");
					out.print("</tr>");
				}
				
			}
		   if("minimum_spend_day".equals(action)) {
			   
				  // int date=Integer.parseInt(request.getParameter("max_spend_d"));
				   String date=request.getParameter("min_spend_d");
				   out.println("<h3>Customer spend minimum of single day </h3>");
					out.println("<table border='1'><tr><th>accno</th><th>amount</th><th>transid</th><th>retailername</th><th>date");
					
					ResultSet rs=st.executeQuery("select accno,min(debit) ,transid,retailername,datet from transaction where (retailername) != 'not null' and (datet) ='"+date+"'");
					
					while(rs.next()) {
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
						out.println(rs.getString(4));
						out.print("</td>");
						out.print("<td>");
						out.println(rs.getString(5));
						out.print("</td>");
						out.print("</tr>");
					}
					
				}
		   if("generate_otp".equals(action)) {
			   Random r = new Random();
				int nextInt=r.nextInt(1000);
				int accnogen=nextInt*4;
				out.println(accnogen);
		   }
		   
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		out.print("</table>");
		
	}

}
