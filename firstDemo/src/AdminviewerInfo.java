

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminviewerInfo
 */
@WebServlet("/AdminviewerInfo")
public class AdminviewerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminviewerInfo() {
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
         int accno=Integer.parseInt(request.getParameter("accno"));
		
		
		try {
			String url="jdbc:mysql://localhost:3306/bs";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, "root", "");
			Statement st= con.createStatement();
			String action=request.getParameter("action");
			if("Approve".equals(action))
			{
				ResultSet rs=st.executeQuery("select * from rtemplate where accno='"+accno+"'");
				String name="",email="",address="",country="",state="",city="",mobile="";
				if(rs.next()) {
			
					name=rs.getString(2);
					email=(rs.getString(3));
					address=(rs.getString(4));
					country=(rs.getString(5));
					state=(rs.getString(6));
			        city=(rs.getString(7));
				
					mobile=rs.getString(8);
					
				}
				 PreparedStatement st1=con.prepareStatement("update user_reg set fname='"+name+"',email='"+email+"',email='"+address+"',email='"+country+"',email='"+state+"',email='"+city+"',email='"+mobile+"' where accno='"+accno+"'");
					//Statement st=con.createStatement();
					int count=0;
				    count= st1.executeUpdate();
			
			
			if(count==1) {

		    	System.out.println("successfully approved");
		    	 PreparedStatement st2= con.prepareStatement("Delete from rtemplate where accno ='"+accno+"'");
				    int n=st2.executeUpdate();
		    	response.sendRedirect("adminviewrequestjsp.jsp");
			}
			else
			{
				out.print("Something went wrong!!!");
			}
			
			
			}
		   if("Reject".equals(action)) {
				
			   PreparedStatement st2= con.prepareStatement("Delete from rtemplate where accno ='"+accno+"'");
			    int n=st2.executeUpdate();
			    if(n==1)
			    {
			    	System.out.println("successfully rejected");
			    	response.sendRedirect("adminviewrequestjsp.jsp");
			    }
			    else
			    {
			    	System.out.println("Not successfull");
			    }
			}
		}catch(Exception e)
			{
				e.printStackTrace();
			}
		
		   

		 
	}
}

		
	


