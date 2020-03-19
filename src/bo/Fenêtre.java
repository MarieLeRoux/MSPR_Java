package bo;

import dal.UserDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class Fenêtre extends JFrame {

    private static CardLayout c1 = new CardLayout();
    private static JPanel content = new JPanel();
    private static JLabel titre = new JLabel("Bienvenue");
    private JLabel label = new JLabel("Login");
    private JLabel label2 = new JLabel("Mot de passe");
    private static JLabel nope = new JLabel("poui");
    private String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};
    public static JTextField field1 = new JTextField("");
    public static JTextField field2 = new JTextField("");
    private JButton boutonlog = new JButton("Connexion");
    private JButton ajout = new JButton("Ajouter un contact");
    private JButton suppr = new JButton("Supprimer un contact");
    private JButton validajout = new JButton("Valider");
    private JButton annulajout = new JButton("Annuler");
    private JLabel labelajout = new JLabel("Ajout");
    private JLabel labelnom = new JLabel("Nom");
    private JTextField textnom = new JTextField("");
    private JLabel labelprenom = new JLabel("Prénom");
    private JTextField textprenom = new JTextField("");
    private JLabel labeltel = new JLabel("Numéro");
    private JTextField texttel = new JTextField("");




    public Fenêtre() throws SQLException {
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
        cell15.setBackground(Color.white);
        cell15.setPreferredSize(new Dimension(200,50));
        //cellule 3x3
        JPanel cell16 = new JPanel();
        cell16.setBackground(Color.white);
        cell16.setPreferredSize(new Dimension(200,50));




        JPanel card1 = new JPanel();
        card1.setPreferredSize(new Dimension(1000,1000));
        card1.setBackground(Color.pink);
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
        //card1.add(cell15, gbc);
        //case 3x3
        gbc.gridx = 3;
        card1.add(cell16, gbc);




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


                int id = checkLogin();
                if (id != 0) {

                    DefaultTableModel model = new DefaultTableModel(new String[]{"Nom", "Prénom", "Téléphone", "Type"}, 0);


                    try {
                        model = UserDAO.get_contacts(id, model);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    JTable table = new JTable(model);
                    card2.add(new JScrollPane(table));;
                    card2.add(ajout);
                    card2.add(suppr);
                }



            }
        });

        //grille 4 x 4
        //cellule 0x0
        JPanel cellu1 = new JPanel();
        cellu1.setBackground(Color.white);
        cellu1.setPreferredSize(new Dimension(200,50));
        //cellule 1x0
        JPanel cellu2 = new JPanel();
        cellu2.setBackground(Color.white);
        cellu2.setPreferredSize(new Dimension(200,50));
        //cellule 2x0
        JPanel cellu3 = new JPanel();
        cellu3.setBackground(Color.white);
        cellu3.setPreferredSize(new Dimension(200,50));
        //cellule 3x0
        JPanel cellu4 = new JPanel();
        cellu4.setBackground(Color.white);
        cellu4.setPreferredSize(new Dimension(200,50));
        //cellule 0x1
        JPanel cellu5 = new JPanel();
        cellu5.setBackground(Color.white);
        cellu5.setPreferredSize(new Dimension(200,50));
        //cellule 1x1
        JPanel cellu6 = new JPanel();
        cellu6.setBackground(Color.white);
        cellu6.setPreferredSize(new Dimension(200,50));
        //cellule 2x1
        JPanel cellu7 = new JPanel();
        cellu7.setBackground(Color.white);
        cellu7.setPreferredSize(new Dimension(200,50));
        //cellule 3x1
        JPanel cellu8 = new JPanel();
        cellu8.setBackground(Color.white);
        cellu8.setPreferredSize(new Dimension(200,50));
        //cellule 0x2
        JPanel cellu9 = new JPanel();
        cellu9.setBackground(Color.white);
        cellu9.setPreferredSize(new Dimension(200,50));
        //cellule 1x2
        JPanel cellu10 = new JPanel();
        cellu10.setBackground(Color.white);
        cellu10.setPreferredSize(new Dimension(200,50));
        //cellule 2x2
        JPanel cellu11 = new JPanel();
        cellu11.setBackground(Color.white);
        cellu11.setPreferredSize(new Dimension(200,50));
        //cellule 3x2
        JPanel cellu12 = new JPanel();
        cellu12.setBackground(Color.white);
        cellu12.setPreferredSize(new Dimension(200,50));
        //cellule 0x3
        JPanel cellu13 = new JPanel();
        cellu13.setBackground(Color.white);
        cellu13.setPreferredSize(new Dimension(200,50));
        //cellule 1x3
        JPanel cellu14 = new JPanel();
        cellu14.setBackground(Color.white);
        cellu14.setPreferredSize(new Dimension(200,50));
        //cellule 2x3
        JPanel cellu15 = new JPanel();
        cellu15.setBackground(Color.white);
        cellu15.setPreferredSize(new Dimension(200,50));
        //cellule 3x3
        JPanel cellu16 = new JPanel();
        cellu16.setBackground(Color.white);
        cellu16.setPreferredSize(new Dimension(200,50));

        JPanel card3 = new JPanel();
        card3.setBackground(Color.gray);
        card3.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();

        //case 0x0
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridheight = 1;
        gbc1.gridwidth = 1;
        card3.add(cellu1, gbc1);
        //case 0x1
        gbc1.gridx = 1;
        //gbc.gridy = 0;
        gbc1.gridwidth = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        card3.add(cellu2, gbc1);
        //case 0x2
        gbc1.gridx = 2;
        card3.add(cellu3, gbc1);
        //case 0x3
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.gridx = 3;
        card3.add(cellu4, gbc1);
        //case 1x0
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.gridheight = 1;
        gbc1.gridwidth = 1;
        card3.add(cellu5, gbc1);
        //case 1x1
        gbc1.gridx = 1;
        card3.add(cellu6, gbc1);
        //case 1x2
        gbc1.gridx = 2;
        card3.add(cellu7, gbc1);
        //case 1x3
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.gridx = 3;
        card3.add(cellu8, gbc1);
        //case 2x0
        gbc1.gridx = 0;
        gbc1.gridy = 2;
        gbc1.gridheight = 1;
        gbc1.gridwidth = 1;
        card3.add(cellu9, gbc1);
        //case 2x1
        gbc1.gridx = 1;
        //gbc.gridwidth = 2;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        card3.add(cellu10, gbc1);
        //case 2x2
        gbc1.gridx = 2;
        card3.add(cellu11, gbc1);
        //case 2x3
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.gridx = 3;
        card3.add(cellu12, gbc1);
        //case 3x0
        gbc1.gridx = 0;
        gbc1.gridy = 3;
        gbc1.gridheight = 1;
        gbc1.gridwidth = 1;
        card3.add(cellu13, gbc1);
        //case 3x1
        gbc1.gridx = 1;
        gbc1.gridwidth = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        card3.add(cellu14, gbc1);
        //case 3x2
        gbc1.gridx = 2;
        card3.add(cellu15, gbc1);
        //case 3x3
        gbc1.gridx = 3;
        card3.add(cellu16, gbc1);

        cellu1.add(labelajout);
        cellu2.add(validajout);
        cellu3.add(annulajout);
        cellu4.add(labelnom);
        cellu5.add(textnom);
        cellu6.add(labelprenom);
        cellu7.add(textprenom);
        cellu8.add(labeltel);
        cellu9.add(texttel);



        ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.next(content);

            }
        });

        validajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.previous(content);
            }
        });

        annulajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.previous(content);
            }
        });


        content.setLayout(c1);

        content.add(card1, listContent[0]);
        content.add(card2, listContent[1]);
        content.add(card3, listContent[2]);

        this.getContentPane().add(content, BorderLayout.CENTER);
    }

    public static int checkLogin() {
        String login = field1.getText();
        String password = field2.getText();

        int id = 0;


        UserDAO userDAO = new UserDAO();

        try {
            User user = userDAO.login(login, password);
            if (user.getName() == null) {
                System.out.println("Mauvais login/mot de passe");
                titre.setText("Mauvais login/mot de passe");

            }
            else {
                System.out.println("Login ok pour l'utilisateur "+user.getName());
                id = user.getId();
                System.out.println(id);

                c1.next(content);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return id;


    }


}