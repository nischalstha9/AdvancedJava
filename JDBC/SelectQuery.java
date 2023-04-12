import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SelectQuery {
    public static void main(String[] args) {
        String dburl = "jdbc:mysql://localhost:3306/user_registration?useSSL=false";
        String username = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(dburl, username, password)) {
            String query = "SELECT * FROM user";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) {
                String name = res.getString("customer_name");
                System.out.println("Name is " + name);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // System.out.println("There was SQL error!");
        }
    }
}
