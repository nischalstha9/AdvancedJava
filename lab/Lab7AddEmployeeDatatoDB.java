// 7.Write a program to insert emplyee information(name,email and address) into MYSQL database
package lab;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Lab7AddEmployeeDatatoDB implements ActionListener {
    JTextField tf, tEmail;
    JFrame f;
    JTextField tAddress;

    public Lab7AddEmployeeDatatoDB() {
        f = new JFrame("Register");
        JLabel lname = new JLabel("Emp Name");
        lname.setBounds(100, 20, 150, 20);
        f.add(lname);

        tf = new JTextField();
        tf.setBounds(180, 20, 150, 20);
        f.add(tf);

        JLabel lemail = new JLabel("Emp Email");
        lemail.setBounds(100, 50, 150, 20);
        f.add(lemail);

        tEmail = new JTextField();
        tEmail.setBounds(180, 50, 150, 20);
        f.add(tEmail);

        JLabel laddress = new JLabel("Address");
        laddress.setBounds(100, 80, 150, 20);
        f.add(laddress);

        tAddress = new JTextField();
        tAddress.setBounds(180, 80, 150, 20);
        f.add(tAddress);

        JButton btn = new JButton("Register");
        btn.setBounds(180, 100, 150, 25);
        btn.addActionListener(this);
        f.add(btn);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = tf.getText();
        String email = tEmail.getText();
        String address = tAddress.getText();
        String dburl = "jdbc:mysql://localhost:3306/employee?useSSL=false";
        String dbusername = "root";
        String dbpassword = "root";
        try (Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)) {
            String query = ("INSERT INTO employee(name,email,address) values('" + user + "','" + email
                    + "','" + address + "')");
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate(query);
            if (res > 0) {
                JDialog d = new JDialog(f, "Register Successful", true);
                d.setLocationRelativeTo(d);
                d.setSize(100, 100);
                d.setVisible(true);
            }
            conn.close();
            tf.setText("");
            tAddress.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Lab7AddEmployeeDatatoDB();
    }

}