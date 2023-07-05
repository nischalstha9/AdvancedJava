import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        String dburl = "jdbc:mysql://localhost:3306/user_registration?useSSL=false";
        String dbusername = "root";
        String dbpassword = "root";

        response.setStatus(200);
        PrintWriter writer = response.getWriter();
        writer.write("Hello world!");

        // try (Connection conn = DriverManager.getConnection(dburl, dbusername,
        // dbpassword)) {
        // String query = "SELECT * FROM user WHERE username='" + username + "' AND
        // password='" + password + "'";
        // Statement stmt = conn.createStatement();
        // ResultSet res = stmt.executeQuery(query);
        // while (res.next()) {
        // if (username.equals(res.getString("username")) &&
        // password.equals(res.getString("password"))) {
        // String ms = "Login Authenticated!";
        // response.setStatus(200);
        // response.getWriter();
        // }
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

    }

}
