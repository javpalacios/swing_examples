package d_formulario.mvc;

import javax.swing.*;
import java.awt.*;

public class D_FormularioView extends JFrame {
    private final D_FormularioController controller;
    private JLabel labelName;
    private JLabel labelEMail;
    private JLabel labelPassword;
    private JTextField textFieldName;
    private JTextField textFieldEMail;
    private JTextField textFieldPassword;
    private JButton buttonSave;
    private JPanel formPanel;
    private JPanel mainPanel;
    private JLabel labelUserCount;

    public D_FormularioView() {
        this.controller = new D_FormularioController(this);

        initComponets();
        addListeners();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(250,250);
        this.setMinimumSize(new Dimension(250,250));
    }

    private void initComponets() {
        labelName = new JLabel("Nombre");
        labelEMail = new JLabel("Correo electrónico");
        labelPassword = new JLabel("Contraseña");
        textFieldName = new JTextField();
        textFieldEMail = new JTextField();
        textFieldPassword = new JTextField();
        buttonSave = new JButton("Guardar");
        formPanel = new JPanel();
        mainPanel = new JPanel();
        labelUserCount = new JLabel("Usuarios :0 ");
        labelUserCount.setHorizontalAlignment(SwingConstants.RIGHT);

        formPanel.setLayout(new GridLayout(4,2));
        formPanel.add(labelName);
        formPanel.add(textFieldName);
        formPanel.add(labelEMail);
        formPanel.add(textFieldEMail);
        formPanel.add(labelPassword);
        formPanel.add(textFieldPassword);
        formPanel.add(new JLabel());
        formPanel.add(buttonSave);

        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(formPanel);

        this.add(mainPanel,BorderLayout.WEST);
        this.add(labelUserCount, BorderLayout.SOUTH);

        this.pack();
    }

    private void addListeners() {
        buttonSave.addActionListener(e -> {
            this.controller.validateForm(textFieldName.getText(),textFieldEMail.getText(),textFieldPassword.getText());
        });
    }

    public void showResult(boolean isValidated, String title, String message){
        JOptionPane.showMessageDialog(this,
                message,
                title,
                isValidated?
                        JOptionPane.INFORMATION_MESSAGE:
                        JOptionPane.ERROR_MESSAGE);
    }

    public void updateUserCount(int userCount){
        labelUserCount.setText("Usuarios: "+String.valueOf(userCount)+" ");
    }
}
