package io.github.spigotrce.chatroom.client;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DarkLoginPageUI {
    public DarkLoginPageUI() {
        JFrame frame = new JFrame("Dark Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setResizable(false);

        // Background panel
        JPanel background = new JPanel();
        background.setBounds(0, 0, 400, 500);
        background.setBackground(Color.decode("#121212")); // Dark theme background
        background.setLayout(null);
        frame.add(background);

        // Title Label
        JLabel titleLabel = new JLabel("Welcome Back");
        titleLabel.setBounds(50, 50, 300, 40);
        titleLabel.setForeground(Color.decode("#BB86FC")); // Blue accent color
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        background.add(titleLabel);

        // Username Field with Placeholder
        JTextField usernameField = new JTextField();
        addPlaceholder(usernameField, "Username");
        usernameField.setBounds(50, 130, 300, 40);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameField.setForeground(Color.WHITE);
        usernameField.setBackground(Color.decode("#1E1E1E"));
        usernameField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        usernameField.setCaretColor(Color.decode("#BB86FC")); // Blue caret color
        background.add(usernameField);

        // Password Field with Placeholder
        JPasswordField passwordField = new JPasswordField();
        addPlaceholder(passwordField, "Password");
        passwordField.setBounds(50, 200, 300, 40);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(Color.decode("#1E1E1E"));
        passwordField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        passwordField.setCaretColor(Color.decode("#BB86FC"));
        background.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 270, 300, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.decode("#1E90FF")); // Blue button background
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        background.add(loginButton);

        // Add listener to the login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
        });

        // Show Frame
        frame.setVisible(true);
    }

    /**
     * Adds placeholder functionality to a text field.
     */
    private static void addPlaceholder(JTextComponent textField, String placeholderText) {
        textField.setText(placeholderText);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholderText)) {
                    textField.setText("");
                    textField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholderText);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
}
