// 8.Write a program to read employee information from MYSQL database
package lab;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab8ReadEmployeeDataFromDB {
    Lab8ReadEmployeeDataFromDB() {
        String dburl = "jdbc:mysql://localhost:3306/employee?useSSL=false";
        String dbusername = "root";
        String dbpassword = "root";
        try (Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)) {
            Statement statement = conn.createStatement();

            ResultSet countSet = statement.executeQuery("SELECT count(*) as count FROM employee");
            countSet.next();
            int count = countSet.getInt("count");

            String sqlQuery = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Create a two-dimensional array to hold the data from the ResultSet
            Object[][] data = new Object[count][4];
            int rowCount = 0;

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                data[rowCount][0] = id;
                data[rowCount][1] = name;
                data[rowCount][2] = email;
                data[rowCount][3] = address;

                rowCount++;
            }

            resultSet.close();
            statement.close();
            conn.close();

            // Create column names for the table
            String[] columnNames = { "ID", "Name", "Email", "Address" };

            // Create the JTable with the data and column names
            JTable table = new JTable(data, columnNames);

            // Set table properties
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            // Create a scroll pane to hold the table
            JScrollPane scrollPane = new JScrollPane(table);

            // Create the main frame
            JFrame frame = new JFrame("Employee Information");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Lab8ReadEmployeeDataFromDB();
    }

}