package d_formulario;

import javax.swing.*;
import java.awt.*;

public class D_FormularioView extends JFrame {
    private JLabel labelName;
    private JLabel labelEMail;
    private JLabel labelPassword;
    private JTextField textFieldName;
    private JTextField textFieldEMail;
    private JTextField textFieldPassword;
    private JButton buttonSave;
    private JPanel mainPanel;

    public D_FormularioView() {
        initComponets();
        addListeners();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
    }

    private void initComponets() {
        labelName = new JLabel("Nombre");
        labelEMail = new JLabel("Correo electrónico");
        labelPassword = new JLabel("Contraseña");
        textFieldName = new JTextField();
        textFieldEMail = new JTextField();
        textFieldPassword = new JTextField();
        buttonSave = new JButton("Guardar");
        mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(4,2));
        mainPanel.add(labelName);
        mainPanel.add(textFieldName);
        mainPanel.add(labelEMail);
        mainPanel.add(textFieldEMail);
        mainPanel.add(labelPassword);
        mainPanel.add(textFieldPassword);
        mainPanel.add(new JLabel());
        mainPanel.add(buttonSave);

        //this.setLayout(new FlowLayout());
        this.add(mainPanel);

        this.pack();
    }

    private void addListeners() {
        buttonSave.addActionListener(e -> this.showResult());
    }

    private void showResult(){
        if (textFieldName.getText().isEmpty() || textFieldEMail.getText().isEmpty() || textFieldPassword.getText().isEmpty())
            JOptionPane.showMessageDialog(this,
                    "Rellena todoslos campos!!",
                    "Error de validación",
                    JOptionPane.ERROR_MESSAGE);
        else if (!textFieldEMail.getText().contains("@"))
            JOptionPane.showMessageDialog(this,
                    "Eso no es un email!!!!",
                    "Error de validación",
                    JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(this,
                    "Qué bien lo hemos hecho!!!!",
                    "Información de validación",
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
