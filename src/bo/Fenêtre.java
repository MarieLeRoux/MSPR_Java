package bo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenêtre extends JFrame {

    private CardLayout c1 = new CardLayout();
    private JPanel content = new JPanel();
    private JLabel label = new JLabel("Login");
    private JLabel label2 = new JLabel("Mot de passe");
    private String[] listContent = {"CARD_1", "CARD_2"};
    private JTextField field1 = new JTextField("");
    private JTextField field2 = new JTextField("");
    JButton boutonlog = new JButton("Connexion");


    public Fenêtre() {
        this.setTitle("Carnet d'adresses");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JPanel card1 = new JPanel();
        card1.setBackground(Color.white);
        card1.add(label);
        card1.add(field1);
        field1.setPreferredSize(new Dimension(150, 30));
        card1.add(label2);
        card1.add(field2);
        field2.setPreferredSize(new Dimension(150, 30));
        card1.add(boutonlog);


        JPanel card2 = new JPanel();
        card2.setBackground(Color.pink);

        boutonlog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.next(content);
            }
        });


        content.setLayout(c1);

        content.add(card1, listContent[0]);
        content.add(card2, listContent[1]);

        this.getContentPane().add(content, BorderLayout.CENTER);
    }
}