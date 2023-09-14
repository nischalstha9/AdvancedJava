import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();

        // JDBC code to retrieve student data from the database
        String jdbcUrl = "jdbc:mysql://db:3306/employee";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT id, name, address FROM employee");

            while (resultSet.next()) {
                Student student = new Student();
                student.id = resultSet.getInt("id");
                student.name = resultSet.getString("name");
                student.address = resultSet.getString("address");
                studentList.add(student);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            Student student = new Student();
            student.id = 22;
            student.name = "NSICAHL";
            student.address = "STHA";
            studentList.add(student);
        }

        request.setAttribute("studentList", studentList);

        // Forward the data to the JSP for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("studentDetails.jsp");
        dispatcher.forward(request, response);
    }
}
