package b_colores;

import javax.swing.*;
import java.awt.*;

public class B_ColoresView extends JFrame {
    private JButton botonRojo;
    private JButton botonVerde;
    private JButton botonAzul;
    private JButton botonAmarillo;
    private JLabel etiquetaColor;

    public B_ColoresView() {
        initComponents();
        addListeners();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
    }


    private void initComponents() {
        botonRojo = new JButton("Rojo");
        botonVerde = new JButton("Verde");
        botonAzul = new JButton("Azul");
        botonAmarillo = new JButton("Amarillo");
        etiquetaColor = new JLabel();

        etiquetaColor.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new BorderLayout());
        this.add(botonRojo,BorderLayout.NORTH);
        this.add(botonVerde,BorderLayout.WEST);
        this.add(botonAzul,BorderLayout.EAST);
        this.add(botonAmarillo,BorderLayout.SOUTH);
        this.add(etiquetaColor,BorderLayout.CENTER);

        this.pack();
    }


    private void addListeners() {
        this.botonAmarillo.addActionListener(e->this.mostrarColor(((JButton)e.getSource()).getText(),Color.YELLOW));
        this.botonVerde.addActionListener(e->this.mostrarColor(((JButton)e.getSource()).getText(),Color.GREEN));
        this.botonAzul.addActionListener(e->this.mostrarColor(((JButton)e.getSource()).getText(),Color.BLUE));
        this.botonRojo.addActionListener(e->this.mostrarColor(((JButton)e.getSource()).getText(),Color.RED));

    }

    private void mostrarColor(String textoColor, Color color){
        this.etiquetaColor.setText(textoColor);
        this.etiquetaColor.setBackground(color);
        this.etiquetaColor.setOpaque(true);
    }
}
