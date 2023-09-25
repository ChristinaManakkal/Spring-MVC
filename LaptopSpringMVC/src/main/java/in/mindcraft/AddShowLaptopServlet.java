package in.mindcraft;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

@WebServlet("/AddShowLaptopServlet")
public class AddShowLaptopServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		 String lidParam = request.getParameter("lid");

		int lid = Integer.parseInt(lidParam);

		 String make = request.getParameter("make");

		 String costParam = request.getParameter("cost");         

		double cost = Double.parseDouble(costParam);

		 String action = request.getParameter("action");

		if ("Add".equals(action)) {


		try {


		 Class.forName("com.mysql.cj.jdbc.Driver");


		 Connection c = DriverManager.getConnection("jdbc:mysql://localhost/laptop_db", "root", "root");


		 PreparedStatement psmt = c.prepareStatement("Insert into laptop values (?,?,?)");
		psmt.setInt(1, lid);
		psmt.setString(2, make);
		psmt.setDouble(3, cost);

		int s = psmt.executeUpdate();

		if(s > 0) {

		response.getWriter().print("Rows Inserted Success!!");

		// response.getWriter().println(lid+ " " +make+ " " +cost);
		 }


		psmt.close();


		c.close();


		 } catch (SQLException | ClassNotFoundException e) {


		e.printStackTrace();


		 }
		 } 


		else if ("Show".equals(action)) 
		 {
		try {


		 Class.forName("com.mysql.cj.jdbc.Driver");


		 Connection c = DriverManager.getConnection("jdbc:mysql://localhost/laptop_db", "root", "root");


		 String query = "SELECT * FROM laptop";


		 PreparedStatement psmt = c.prepareStatement(query);
		 ResultSet rst = psmt.executeQuery(); 
		request.setAttribute("laptopResultSet", rst);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		rst.close();
		psmt.close();
		c.close();
		 } catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
		 }
		 }
		 }
}
