package bo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenêtre extends JFrame {
    //private JButton bouton = new JButton("bouton");
    //private JButton bouton2 = new JButton("ou pas");
    //private JPanel pan = new JPanel();
    CardLayout c1 = new CardLayout();
    JPanel content = new JPanel();
    JLabel label = new JLabel("boiboite");
    JLabel label2 = new JLabel("blah");
    String[] listContent = {"CARD_1", "CARD_2"};
    int indice = 0;
    JComboBox combo = new JComboBox();

    public Fenêtre() {
        this.setTitle("WALLAH");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JPanel card1 = new JPanel();
        card1.setBackground(Color.blue);
        card1.add(label2);
        card1.add(combo);


        JPanel card2 = new JPanel();
        card2.setBackground(Color.pink);
        card2.add(label);

        JPanel boutonPane = new JPanel();
        JButton bouton3 = new JButton("suite");
        bouton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.next(content);
            }
        });

        JButton bouton4 = new JButton("par indice");
        bouton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (++indice > 2)
                    indice = 0;
                c1.show(content, listContent[indice]);
            }

        });

        boutonPane.add(bouton3);
        //boutonPane.add(bouton4);
        content.setLayout(c1);

        combo.setPreferredSize(new Dimension(100, 20));
        combo.addItem("Option 1");
        combo.addItem("Option 2");


        content.add(card1, listContent[0]);
        content.add(card2, listContent[1]);

        this.getContentPane().add(boutonPane, BorderLayout.NORTH);
        this.getContentPane().add(content, BorderLayout.CENTER);
    }
}