import javax.swing.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Register implements ActionListener {
    JTextField tfUser;
    JPasswordField tfPassword;
    JButton JSubmit;
    JFrame f;

    public Register() {
        f = new JFrame("Register");
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
        JSubmit.setText("Register");
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
            String query = "INSERT INTO user(`username`, `password`) VALUES ('" + username + "', '" + password + "')";
            Statement stmt = conn.createStatement();
            int affectedRows = stmt.executeUpdate(query);
            if (affectedRows > 0) {
                JDialog dialog = new JDialog(f, "User Creation Success", true);
                dialog.setLocationRelativeTo(dialog);
                dialog.setSize(400, 100);
                dialog.setVisible(true);
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
