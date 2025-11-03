package org.example;

import javax.swing.*;

public class DetalleUsuario {
    private JTextArea textArea1;

    public DetalleUsuario(String texto) {
        JFrame frame = new JFrame("Detalle del Usuario");
        textArea1 = new JTextArea(texto);
        textArea1.setEditable(false);
        frame.add(new JScrollPane(textArea1));
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}