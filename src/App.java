import bo.Fenêtre;
import bo.User;
import dal.UserDAO;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       Fenêtre fenetre = new Fenêtre();

    }
    public static void createContact() {
        System.out.println("******CREATION********");
        String name, login, password;

        System.out.println("Quel est le nom du contact ?");
        name = sc.nextLine();
        //sc.nextLine();
        //System.out.println(name);
        System.out.println("Quel est le login du contact ?");
        login = sc.nextLine();
        //sc.nextLine();
        System.out.println("Quel est le mot de passe du contact ?");
        password = sc.nextLine();

        User user = new User (name, login, password);
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.create(user);
            System.out.println("Contact "+name+" créé");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //dsMainMenu();
    }

    public static void dspContact() {
        System.out.println("*******LISTE DES CONTACTS********");
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
        //dsMainMenu();
    }

    public static void removeContact() {
        System.out.println("******SUPPRESSION********");
        int id;
        System.out.println("id wallah");
        id = sc.nextInt();
        UserDAO userDAO = new UserDAO();
        try {
            //User user = userDAO.remove(id);
            userDAO.remove(id);
            //System.out.printf( "%-5d %-10s %-10s%n", user.getId(), user.getName(), user.getLogin() );

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //dsMainMenu();

    }

    public static void showContact() {
        System.out.println("*******AFFICHER UN CONTACT********");
        int id;
        System.out.println("Tu veux quoi ?");
        id = sc.nextInt();
        UserDAO userDAO = new UserDAO();

        try {
            User user = userDAO.findById(id);
            System.out.printf( "%-5d %-10s %-10s%n", user.getId(), user.getName(), user.getLogin() );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //dsMainMenu();
    }

    public static void updateContact() {
        System.out.println("******UPDATE********");
        int id;

        String name, login, password;
        System.out.println("id wallah");
        id = sc.nextInt();
        sc.nextLine();

        System.out.println("Nouveau nom");
        name = sc.nextLine();
        //sc.nextLine();
        //System.out.println(name);
        System.out.println("Nouveau login");
        login = sc.nextLine();
        //sc.nextLine();
        System.out.println("Nouveau mot de passe");
        password = sc.nextLine();

        User user = new User (name, login, password);
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.update(id, user);
            System.out.println("Contact "+name+" modifié");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //dsMainMenu();
    }


}


