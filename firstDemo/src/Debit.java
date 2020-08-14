

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Debit
 */
@WebServlet("/Debit")
public class Debit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Debit() {
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
			int acc2=Integer.parseInt(request.getParameter("accno"));
			int acc1=Integer.parseInt(request.getParameter("accno1"));
			int amount=Integer.parseInt(request.getParameter("amnt"));
			String name= request.getParameter("name");
			
			int amntsender=0;
			int amntreceiver=0;
			
			
			try {
				String url="jdbc:mysql://localhost:3306/bs";
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection(url, "root", "");
				Statement st= con.createStatement();
				ResultSet rs=st.executeQuery("select amount from balance where accno='"+acc1+"'");
				
				if(rs.next()) {
					
					amntreceiver=rs.getInt(1);
					
					
				}
				else
				{
					out.println("Wrong credentials");
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			try {
				String url="jdbc:mysql://localhost:3306/bs";
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection(url, "root", "");
				Statement st= con.createStatement();
				ResultSet rs=st.executeQuery("select amount from balance where accno='"+acc2+"'");
				
				if(rs.next()) {
					
					amntsender=rs.getInt(1);
				
					
				}
				else
				{
					out.println("Wrong credentials");
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			int finalamntsender=amntsender-amount;
			int finalamntreciever=amntreceiver+amount;
			
		
			
			Random r = new Random();
			int nextInt=r.nextInt(1000000);
			int tansidgen=nextInt*6;
			
			LocalDate d= LocalDate.now();
			
			if(finalamntsender>0)
			{
			try {
				String url="jdbc:mysql://localhost:3306/bs";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection(url, "root", "");
				PreparedStatement st=con.prepareStatement("update balance set amount='"+finalamntsender+"'where accno='"+acc2+"'");
				PreparedStatement st1=con.prepareStatement("update balance set amount='"+finalamntreciever+"'where accno='"+acc1+"'");
				PreparedStatement st2=con.prepareStatement("insert into transaction(accno,transid,credit,datet)values('"+acc1+"','"+tansidgen+"','"+amount+"','"+d+"')");
				PreparedStatement st3=con.prepareStatement("insert into transaction(accno,transid,debit,retailername,datet)values('"+acc2+"','"+tansidgen+"','"+amount+"','"+name+"','"+d+"')");
				//Statement st=con.createStatement();
				int count=0;
			    count= st.executeUpdate();
			    count= st1.executeUpdate();
			    count= st2.executeUpdate();
			    count= st3.executeUpdate();
			    
			
				if((count==1))
				{
					out.println("<table border='1'><tr><th>STATUS</th><th>AMOUNT</th><th>TRANSACTION ID</th><th>Receiver name</th><th>Date</th>");
					out.print("<tr><td>");
					out.println("Transaction successfull");
					out.print("</td>");
					out.print("<td>");
					out.print(amount);
					out.print("</td>");
					out.print("<td>");
					out.print(tansidgen);
					out.print("</td>");
					out.print("<td>");
					out.print(name);
					out.print("</td>");
					out.print("<td>");
					out.print(d);
					out.print("</td>");
					out.print("</tr>");
				}
				else
				{
					out.print("Transaction failure!!!!!1");
				}
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			out.print("</table>");
			}
			else
			{
				out.println("NOT ENOUGH BALANCEE!!!!!!!!!!!!");
			}
		
	}

}
