import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrationForm extends JFrame {
    private JPanel logoPanel;
    private JPanel formPanel;
    private JLabel logoLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel ageLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel votersIdLabel;
    private JLabel constituencyLabel;
    private JLabel loginLinkLabel;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField ageField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField votersIdField;
    private JTextField constituencyField;

    private JButton registerButton;
    private JButton cancelButton;

    public RegistrationForm() {
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Add spacing between components

        // Create the logo panel
        logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(new Color(248, 148, 6));

        // Add the logo image
        ImageIcon logoImage = new ImageIcon("img/Kenya.png"); // Replace with the actual path to your logo image
        logoLabel = new JLabel(logoImage);
        logoPanel.add(logoLabel, BorderLayout.CENTER);

        // Create the "REGISTER" label
        JLabel registerLabel = new JLabel("REGISTER");
        registerLabel.setFont(new Font("Arial", Font.ITALIC, 24));
        registerLabel.setForeground(Color.WHITE);
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoPanel.add(registerLabel, BorderLayout.SOUTH);

        // Create the form panel
        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(44, 62, 80));
        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.anchor = GridBagConstraints.WEST;
        gbcForm.insets = new Insets(10, 10, 10, 10); // Add more spacing here (top, left, bottom, right)

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setForeground(Color.WHITE);
        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setForeground(Color.WHITE);
        ageLabel = new JLabel("Age:");
        ageLabel.setForeground(Color.WHITE);
        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setForeground(Color.WHITE);
        votersIdLabel = new JLabel("Voters ID No:");
        votersIdLabel.setForeground(Color.WHITE);
        constituencyLabel = new JLabel("Constituency:");
        constituencyLabel.setForeground(Color.WHITE);

        firstNameField = new JTextField(25);
        lastNameField = new JTextField(25);
        ageField = new JTextField(25);
        emailField = new JTextField(25);
        passwordField = new JPasswordField(25);
        confirmPasswordField = new JPasswordField(25);
        votersIdField = new JTextField(25);
        constituencyField = new JTextField(25);

        registerButton = new JButton("Register");
        cancelButton = new JButton("Cancel");

        // Create the login link label
        loginLinkLabel = new JLabel("<html><u>Click here to login</u></html>");
        loginLinkLabel.setForeground(Color.WHITE);
        loginLinkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLinkLabel.setFont(loginLinkLabel.getFont().deriveFont(Font.PLAIN, 12));
        loginLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the login link click event
                dispose(); // Close the RegistrationForm
                new LoginForm(); // Open the LoginForm
            }
        });

        gbcForm.gridx = 0;
        gbcForm.gridy = 0;
        formPanel.add(firstNameLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(firstNameField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 1;
        formPanel.add(lastNameLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(lastNameField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 2;
        formPanel.add(ageLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(ageField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 3;
        formPanel.add(emailLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(emailField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 4;
        formPanel.add(passwordLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(passwordField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 5;
        formPanel.add(confirmPasswordLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(confirmPasswordField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 6;
        formPanel.add(votersIdLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(votersIdField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 7;
        formPanel.add(constituencyLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(constituencyField, gbcForm);

        // Create a panel for the buttons and login link
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(44, 62, 80));
        cancelButton.setBackground(new Color(255, 125, 125)); // Light red background color
        registerButton.setBackground(new Color(125, 165, 255)); // Light blue background color
        buttonPanel.add(cancelButton);
        buttonPanel.add(registerButton);

        JPanel linkPanel = new JPanel();
        linkPanel.setBackground(new Color(44, 62, 80));
        linkPanel.add(loginLinkLabel);

        // Create a panel for the buttons and login link panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(44, 62, 80));
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(linkPanel, BorderLayout.CENTER);

        // Add the panels to the frame
        add(logoPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle cancel button click event
                dispose(); // Close the RegistrationForm
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle register button click event
                // Implement your registration logic here
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm());
    }
}
