package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPanel extends JFrame {
    private JTextArea textArea1;
    private JLabel lblTitulo;
    private JLabel lblanadir;
    private JLabel lblautor;
    private JButton agregarButton;
    private JButton btnCerrar;
    private JTextField txtnombre;
    private JTextField txtpais;
    private JTextField txtPlataforma;
    private JLabel lblplataforma;
    public AdminPanel() {

        // Configuración del panel principal
        JPanel panel = new JPanel();
        setContentPane(panel);
        setTitle("Panel de Administración");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel.setLayout(null);
     

        // Inicialización de componentes
        textArea1.setText("Ana López - España - Spotify\n");
        textArea1.append("Carlos Méndez - México - YouTube\n");

        textArea1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    try {
                        int pos = textArea1.viewToModel(evt.getPoint());
                        String texto = textArea1.getText();
                        int inicio = 0;
                        int fin = texto.length();

                        // Buscar inicio de la línea
                        for (int i = pos; i >= 0; i--) {
                            if (texto.charAt(i) == '\n') {
                                inicio = i + 1;
                                break;
                            }
                        }
                        // Buscar fin de la línea
                        for (int i = pos; i < texto.length(); i++) {
                            if (texto.charAt(i) == '\n') {
                                fin = i;
                                break;
                            }
                        }

                        String linea = texto.substring(inicio, fin).trim();
                        if (!linea.isEmpty()) {
                            new DetalleUsuario(linea);
                        }
                    } catch (Exception ex) {

                    }
                }
            }
        });

        // === Botón Agregar ===
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtnombre.getText().trim();
                String pais = txtpais.getText().trim();
                String plataforma = txtPlataforma.getText().trim();

                if (nombre.isEmpty() || pais.isEmpty() || plataforma.isEmpty()) {
                    JOptionPane.showMessageDialog(AdminPanel.this, "Todos los campos son obligatorios.");
                    return;
                }

                textArea1.append(nombre + " - " + pais + " - " + plataforma + "\n");

                // Limpiar campos
                txtnombre.setText("");
                txtpais.setText("");
                txtPlataforma.setText("");
                txtnombre.requestFocus();
            }
        });


        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });





    }
}