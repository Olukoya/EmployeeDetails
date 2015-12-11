import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Form")
public class Form extends HttpServlet  
{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		}
	
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	 res.setContentType("text/html");  
         
         Connection con=null;     
         
         
         try
         {
        	 
        	 String eNumber= req.getParameter("eNumber");
        	 String fName= req.getParameter("fName");
             String lName= req.getParameter("lName");
             String dept= req.getParameter("dept");
             
             System.out.println(eNumber);
             System.out.println(fName);
             System.out.println(lName);
             System.out.println(dept);
        	            
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
        	 System.out.println("Driver loaded");
        	  String url = "jdbc:oracle:thin:@localhost:1521:xe";
        	    String username = "SYS as SYSDBA";
        	    String password = "password";
        	con = DriverManager.getConnection(url, username, password);
        	Statement st = con.createStatement();
         st.executeUpdate("insert into Employees (emp_no,f_name,l_name,dept) values('"+eNumber+"','"+fName+"','"+lName+"','"+dept+"')");
         con.close();
         }
         catch(Exception e)
         {
           System.err.println(e);       
         }
         getServletContext().getRequestDispatcher("/viewEmployee.jsp").forward(req, res);       
         }
        
    }
