package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
public RegistrationServlet() {
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String name = request.getParameter("name");
   String email = request.getParameter("email");
   String password = request.getParameter("password");
   if (insertUser(name, email, password)) {
      response.getWriter().println("User registered successfully.");
   } else {
      response.getWriter().println("User registration failed.");
   }

}

public static boolean insertUser(String name, String email, String password) {
   try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String jdbcUrl = "jdbc:mysql://localhost:3306/login_register";
      String dbUser = "root";
      String dbPassword = "1234";
      Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
      String insertQuery = "INSERT INTO register (name, email, password) VALUES (?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, email);
      preparedStatement.setString(3, password);
      int rowsAffected = preparedStatement.executeUpdate();
      preparedStatement.close();
      connection.close();
      return rowsAffected > 0;
   } catch (Exception var10) {
      var10.printStackTrace();
      return false;
   }
}
}
