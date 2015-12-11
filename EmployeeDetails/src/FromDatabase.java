

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FromDatabase
 */
@WebServlet("/FromDatabase")
public class FromDatabase extends HttpServlet {
	static String emp, fn,ln,de="";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FromDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				Connection con = null;
			
				String line;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 System.out.println("Driver loaded");
					  String url = "jdbc:oracle:thin:@localhost:1521:xe";
					    String username = "SYS as SYSDBA";
					    String password = "password";
					con = DriverManager.getConnection(url, username, password);
					Statement st = con.createStatement();
					String sql = "select * from Employees";
					ResultSet rs= st.executeQuery(sql);

   line = "<table class=" 
						+ "\"table table-striped\"" 
						+ "style=width:60%>";
      
      line += 
					"<tr>" 
					+"<th>" + "Emp Number" + "</th> <br>"
					+"<th>" + "First Name" + "</th> <br>"
					+"<th>" + "Last Name" + "</th> <br>"
					+"<th>" + "Department" + "</th> <br>"
					+ "</tr>"
					;

      while (rs.next())	
      {
      emp = rs.getString("emp_no");
      fn = rs.getString("f_name");
      ln = rs.getString("l_name");
      de = rs.getString("dept");

					line += "<tr>" 
							+"<td>" + emp+"</td>"
							+"<td>" + fn+ "</td>"
							+"<td>" + ln+"</td>"
							+"<td>" + de+ "</td>"
							+"</tr>"
					        ;	
      }		
					line += "</table>";
					request.setAttribute("all", line);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			getServletContext().getRequestDispatcher("/viewEmployee.jsp").forward(request, response);
	}

}
