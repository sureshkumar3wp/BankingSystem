

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Base64;
import java.util.Random;
/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		
		String fname=request.getParameter("fname");
		String email=request.getParameter("email");
		String uname=request.getParameter("uname");
		final String orgstr=request.getParameter("pass");
	
		 String pass = Base64.getEncoder().encodeToString(orgstr.getBytes("UTF-8"));
		 
		final String corgstr=request.getParameter("cpass");
		
		 String cpass = Base64.getEncoder().encodeToString(corgstr.getBytes("UTF-8"));
		
		String dob=request.getParameter("dob");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String  mobile=request.getParameter("mobile");
		Random r = new Random();
		int nextInt=r.nextInt(100000000);
		int accnogen=nextInt*8;
		 int amount=1000;
		try {
			String url="jdbc:mysql://localhost:3306/bs";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, "root", "");
			PreparedStatement st=con.prepareStatement("insert into user_reg(fname,email,uname,pass,cpass,dob,age,gender,address,country,state,city,mobile,accno)values('"+fname+"','"+email+"','"+uname+"','"+pass+"','"+cpass+"','"+dob+"','"+age+"','"+gender+"','"+address+"','"+country+"','"+state+"','"+city+"','"+mobile+"','"+accnogen+"')");
			//Statement st=con.createStatement();
			int count=0;
		    count= st.executeUpdate();
		    
		
			if((count==1))
			{
				
				System.out.println("Registeration successfull");
			}
			else
			{
				System.out.println("not inserted");
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		try {
			String url="jdbc:mysql://localhost:3306/bs";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, "root", "");
			PreparedStatement st=con.prepareStatement("insert into balance(accno,name,amount)values('"+accnogen+"','"+fname+"','"+amount+"')");
			//Statement st=con.createStatement();
			int count=0;
		    count= st.executeUpdate();
		    
		
			if((count==1))
			{
				
				response.sendRedirect("login.jsp");
			}
			else
			{
				System.out.println("not inserted");
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
