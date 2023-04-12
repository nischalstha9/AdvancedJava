import javax.swing.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Login implements ActionListener {
    JTextField tfUser;
    JPasswordField tfPassword;
    JButton JSubmit;
    JFrame f;

    public Login() {
        f = new JFrame("Login");
        JLabel lUser = new JLabel("Username");
        lUser.setBounds(20, 20, 150, 25);
        f.add(lUser);

        tfUser = new JTextField();
        tfUser.setBounds(180, 20, 150, 25);
        f.add(tfUser);

        JLabel lPassword = new JLabel("Password");
        lPassword.setBounds(20, 55, 150, 25);
        f.add(lPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(180, 55, 150, 25);
        f.add(tfPassword);

        JSubmit = new JButton();
        JSubmit.setText("Login");
        JSubmit.setBounds(180, 90, 150, 25);
        JSubmit.addActionListener(this);
        f.add(JSubmit);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = tfUser.getText();
        String password = tfPassword.getText();

        String dburl = "jdbc:mysql://localhost:3306/user_registration?useSSL=false";
        String dbusername = "root";
        String dbpassword = "root";

        try (Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)) {
            // Class.forName("com.mysql.jdbc.Driver");
            // Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword);
            String query = "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                if (username.equals(res.getString("username")) && password.equals(res.getString("password"))) {
                    JDialog dialog = new JDialog(f, "Authenticated", true);
                    dialog.setLocationRelativeTo(dialog);
                    dialog.setSize(400, 100);
                    dialog.setVisible(true);
                }
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}