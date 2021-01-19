package movieticketsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");

    LoginGUI() {
        setTitle("Login Form");
        setVisible(true);
        setBounds(450, 220, 350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setBounds(50, 170, 100, 30);
        userTextField.setBounds(150, 100, 150, 30);
        passwordField.setBounds(150, 170, 150, 30);
        loginButton.setBounds(50, 250, 100, 30);
        resetButton.setBounds(200, 250, 100, 30);

    }

    public void addComponentsToContainer() {

        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {

            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();

            if (userText.equalsIgnoreCase("omar12") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful For Manager");
                setVisible(false);
                ManagerGUI Manager = new ManagerGUI();
            } else if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("password")) {
                JOptionPane.showMessageDialog(this, "Login Successful For Cashier");
                setVisible(false);
                CashierGUI Manager = new CashierGUI();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
    }

}
