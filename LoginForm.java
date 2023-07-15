import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame {
    private JPanel logoPanel;
    private JLabel logoLabel;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JLabel userTypeLabel;
    private JTextField idField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel createAccountLabel;

    public LoginForm() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the logo panel
        logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(new Color(248, 148, 6));

        // Add the logo image
        ImageIcon logoImage = new ImageIcon("img/Kenya.png"); // Replace with the actual path to your logo image
        logoLabel = new JLabel(logoImage);
        logoPanel.add(logoLabel, BorderLayout.CENTER);

        // Create the form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(44, 62, 80));
        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.anchor = GridBagConstraints.WEST;
        gbcForm.insets = new Insets(10, 5, 10, 5); // Add more spacing here (top, left, bottom, right)

        idLabel = new JLabel("ID no:");
        idLabel.setForeground(Color.WHITE); // Set the text color to white
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE); // Set the text color to white
        userTypeLabel = new JLabel("User Type:");
        userTypeLabel.setForeground(Color.WHITE); // Set the text color to white
        idField = new JTextField(20);
        passwordField = new JPasswordField(20);
        userTypeComboBox = new JComboBox<>(new String[]{"Admin", "Voter"});
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        createAccountLabel = new JLabel("<html><u>Click here to create a new account</u></html>");
        createAccountLabel.setForeground(Color.WHITE); // Set the text color to white
        createAccountLabel.setFont(createAccountLabel.getFont().deriveFont(Font.PLAIN, 12)); // Set the font size to 12

        gbcForm.gridx = 0;
        gbcForm.gridy = 0;
        formPanel.add(idLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(idField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 1;
        formPanel.add(passwordLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(passwordField, gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 2;
        formPanel.add(userTypeLabel, gbcForm);
        gbcForm.gridx = 1;
        formPanel.add(userTypeComboBox, gbcForm);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(44, 62, 80));

        cancelButton.setBackground(new Color(255, 102, 102)); // Set the background color of the cancel button to light red
        loginButton.setBackground(new Color(102, 204, 255)); // Set the background color of the login button to light blue

        buttonPanel.add(cancelButton);
        buttonPanel.add(loginButton);

        gbcForm.gridx = 0;
        gbcForm.gridy = 3;
        gbcForm.gridwidth = 2; // Span the buttons across both columns
        formPanel.add(buttonPanel, gbcForm);

        // Add the create account label
        gbcForm.gridx = 0;
        gbcForm.gridy = 4;
        gbcForm.gridwidth = 2;
        gbcForm.insets = new Insets(5, 0, 0, 0); // Update the top inset to 5
        formPanel.add(createAccountLabel, gbcForm);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle login button click event
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                String userType = (String) userTypeComboBox.getSelectedItem();
                System.out.println("ID: " + id);
                System.out.println("Password: " + password);
                System.out.println("User Type: " + userType);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle cancel button click event
                dispose(); // Close the Login form
            }
        });

        createAccountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle create account label click event
                dispose(); // Close the Login form
                new RegistrationForm(); // Open the RegistrationForm
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                createAccountLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand when hovering over the label
            }

            @Override
            public void mouseExited(MouseEvent e) {
                createAccountLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Change cursor back to default when not hovering over the label
            }
        });

        // Add the panels to the frame
        add(logoPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}
