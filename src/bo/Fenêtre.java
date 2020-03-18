package bo;

import dal.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Set;

public class Fenêtre extends JFrame {

    private static CardLayout c1 = new CardLayout();
    private static JPanel content = new JPanel();
    private static JLabel titre = new JLabel("Bienvenue");
    private JLabel label = new JLabel("Login");
    private JLabel label2 = new JLabel("Mot de passe");
    private static JLabel nope = new JLabel("poui");
    private String[] listContent = {"CARD_1", "CARD_2"};
    public static JTextField field1 = new JTextField("");
    public static JTextField field2 = new JTextField("");
    private JButton boutonlog = new JButton("Connexion");


    public Fenêtre() {
        this.setTitle("Carnet d'adresses");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);





        //grille 4 x 4
        //cellule 0x0
        JPanel cell1 = new JPanel();
        cell1.setBackground(Color.white);
        cell1.setPreferredSize(new Dimension(200,50));
        //cellule 1x0
        JPanel cell2 = new JPanel();
        cell2.setBackground(Color.white);
        cell2.setPreferredSize(new Dimension(200,50));
        //cellule 2x0
        JPanel cell3 = new JPanel();
        cell3.setBackground(Color.white);
        cell3.setPreferredSize(new Dimension(200,50));
        //cellule 3x0
        JPanel cell4 = new JPanel();
        cell4.setBackground(Color.white);
        cell4.setPreferredSize(new Dimension(200,50));
        //cellule 0x1
        JPanel cell5 = new JPanel();
        cell5.setBackground(Color.white);
        cell5.setPreferredSize(new Dimension(200,50));
        //cellule 1x1
        JPanel cell6 = new JPanel();
        cell6.setBackground(Color.white);
        cell6.setPreferredSize(new Dimension(200,50));
        //cellule 2x1
        JPanel cell7 = new JPanel();
        cell7.setBackground(Color.white);
        cell7.setPreferredSize(new Dimension(200,50));
        //cellule 3x1
        JPanel cell8 = new JPanel();
        cell8.setBackground(Color.white);
        cell8.setPreferredSize(new Dimension(200,50));
        //cellule 0x2
        JPanel cell9 = new JPanel();
        cell9.setBackground(Color.white);
        cell9.setPreferredSize(new Dimension(200,50));
        //cellule 1x2
        JPanel cell10 = new JPanel();
        cell10.setBackground(Color.white);
        cell10.setPreferredSize(new Dimension(200,50));
        //cellule 2x2
        JPanel cell11 = new JPanel();
        cell11.setBackground(Color.white);
        cell11.setPreferredSize(new Dimension(200,50));
        //cellule 3x2
        JPanel cell12 = new JPanel();
        cell12.setBackground(Color.white);
        cell12.setPreferredSize(new Dimension(200,50));
        //cellule 0x3
        JPanel cell13 = new JPanel();
        cell13.setBackground(Color.white);
        cell13.setPreferredSize(new Dimension(200,50));
        //cellule 1x3
        JPanel cell14 = new JPanel();
        cell14.setBackground(Color.white);
        cell14.setPreferredSize(new Dimension(200,50));
        //cellule 2x3
        JPanel cell15 = new JPanel();
        cell12.setBackground(Color.white);
        cell12.setPreferredSize(new Dimension(200,50));
        //cellule 3x3
        JPanel cell16 = new JPanel();
        cell16.setBackground(Color.white);
        cell16.setPreferredSize(new Dimension(200,50));




        JPanel card1 = new JPanel();
        card1.setPreferredSize(new Dimension(1000,1000));
        card1.setBackground(Color.white);
        card1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //case 0x0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        card1.add(cell1, gbc);
        //case 0x1
        gbc.gridx = 1;
        //gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        card1.add(cell2, gbc);
        //case 0x2
        //gbc.gridx = 2;
        //card1.add(cell3, gbc);
        //case 0x3
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 3;
        card1.add(cell4, gbc);
        //case 1x0
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        card1.add(cell5, gbc);
        //case 1x1
        gbc.gridx = 1;
        card1.add(cell6, gbc);
        //case 1x2
        gbc.gridx = 2;
        card1.add(cell7, gbc);
        //case 1x3
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 3;
        card1.add(cell8, gbc);
        //case 2x0
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        card1.add(cell9, gbc);
        //case 2x1
        gbc.gridx = 1;
        //gbc.gridwidth = 2;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        card1.add(cell10, gbc);
        //case 2x2
        gbc.gridx = 2;
        card1.add(cell11, gbc);
        //case 2x3
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 3;
        card1.add(cell12, gbc);
        //case 3x0
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        card1.add(cell13, gbc);
        //case 3x1
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        card1.add(cell14, gbc);
        //case 3x2
        //gbc.gridx = 2;
        //card1.add(cell15);
        //case 3x3
        gbc.gridx = 3;
        card1.add(cell16);




        //card1.add(label);
        //card1.add(field1);
        cell2.add(titre);
        cell6.add(label);
        cell7.add(field1);
        field1.setPreferredSize(new Dimension(100, 30));
        //card1.add(label2);
        //card1.add(field2);
        cell10.add(label2);
        cell11.add(field2);
        field2.setPreferredSize(new Dimension(100, 30));
        //card1.add(boutonlog);
        cell14.add(boutonlog);




        JPanel card2 = new JPanel();
        card2.setBackground(Color.pink);

        boutonlog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                checkLogin();


            }
        });


        content.setLayout(c1);

        content.add(card1, listContent[0]);
        content.add(card2, listContent[1]);

        this.getContentPane().add(content, BorderLayout.CENTER);
    }

    public static void checkLogin() {
        String login = field1.getText();
        String password = field2.getText();


        UserDAO userDAO = new UserDAO();

        try {
            User user = userDAO.login(login, password);
            if (user.getName() == null) {
                System.out.println("Mauvais login/mot de passe");
                titre.setText("Mauvais login/mot de passe");
            }
            else {
                System.out.println("Login ok pour l'utilisateur "+user.getName());
                c1.next(content);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void dspContact() {

        UserDAO userDAO = new UserDAO();

        try {
            Set<User> users = userDAO.findAll();
            for ( User user : users ) {
                System.out.printf( "%-5d %-10s %-10s%n", user.getId(), user.getName(), user.getLogin() );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }

    }
}