// 1.Create Login user interface by Extending The JFrame Class

package lab;

import javax.swing.*;

public class Lab1LoginForm extends JFrame {
    JTextField tfUser;
    JPasswordField tfPassword;
    JButton JSubmit;

    public Lab1LoginForm(String title) {
        super(title);
        JLabel lUser = new JLabel("Username");
        lUser.setBounds(20, 20, 150, 25);
        add(lUser);

        tfUser = new JTextField();
        tfUser.setBounds(180, 20, 150, 25);
        add(tfUser);

        JLabel lPassword = new JLabel("Password");
        lPassword.setBounds(20, 55, 150, 25);
        add(lPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(180, 55, 150, 25);
        add(tfPassword);

        JSubmit = new JButton();
        JSubmit.setText("Login");
        JSubmit.setBounds(180, 90, 150, 25);
        add(JSubmit);

        setSize(500, 500);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Lab1LoginForm("Login");
    }
}