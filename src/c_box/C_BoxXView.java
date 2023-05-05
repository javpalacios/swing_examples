package c_box;

import javax.swing.*;
import java.awt.*;

public class C_BoxXView extends JFrame {
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JPanel panelPrincipal;

    public C_BoxXView() {
        initComponents();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
    }

    private void initComponents() {
        boton1 = new JButton("1");
        boton2 = new JButton("2");
        boton3 = new JButton("3");
        boton4 = new JButton("4");
        boton5 = new JButton("5");
        panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.X_AXIS));
        panelPrincipal.add(boton1);
        panelPrincipal.add(boton2);
        panelPrincipal.add(boton3);
        panelPrincipal.add(boton4);
        panelPrincipal.add(boton5);

        this.add(panelPrincipal);

        pack();
    }
}
