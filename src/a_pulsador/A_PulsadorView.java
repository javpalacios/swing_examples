package a_pulsador;

import a_pulsador.A_PulsadorController;

import javax.swing.*;
import java.awt.*;

public class A_PulsadorView extends JFrame {
    private JLabel etiquetaPantalla;
    private JButton botonMenos;
    private JButton botonMas;
    private JPanel panelPrincipal;
    private JPanel panelTeclado;
    private A_PulsadorController controller;

    public A_PulsadorView() {
        this.controller = new A_PulsadorController(this);

        initComponents();
        addListeners();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
    }

    private void initComponents() {
        etiquetaPantalla = new JLabel("0");
        botonMenos = new JButton("-");
        botonMas = new JButton("+");
        panelPrincipal = new JPanel();
        panelTeclado = new JPanel();

        etiquetaPantalla.setHorizontalAlignment(SwingConstants.CENTER);

        panelTeclado.setLayout(new GridLayout(1,2));
        panelTeclado.add(botonMenos);
        panelTeclado.add(botonMas);

        panelPrincipal.setLayout(new GridLayout(2,1));
        panelPrincipal.add(etiquetaPantalla);
        panelPrincipal.add(panelTeclado);

        this.add(panelPrincipal);

        pack();
    }

    private void addListeners() {
        this.botonMas.addActionListener(e-> this.controller.incrementa());
        this.botonMenos.addActionListener(e-> this.controller.decrementa());
    }

    public void setNumero(int numero) {
        this.etiquetaPantalla.setText(String.valueOf(numero));
    }
}
