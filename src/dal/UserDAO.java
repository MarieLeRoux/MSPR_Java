package dal;

import bo.User;

import javax.swing.table.DefaultTableModel;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserDAO {
    private static final String CREATE_QUERY = "INSERT INTO user (name, login, password) VALUES (?,?,?)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM user";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM user WHERE id = ?";
    private static final String FIND_BY_LOG_AND_PWD = "SELECT * FROM user WHERE login = ? AND password = ?";
    private static final String UPDATE_QUERY = "UPDATE user SET name = ?, login = ?, password = ? WHERE id = ?";

    public void create(User user) throws SQLException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if(null != connection) {
            try (PreparedStatement pst = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)){
                pst.setString(1, user.getName());
                pst.setString(2, user.getLogin());
                pst.setString(3, user.getPassword());
                pst.executeUpdate();
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    if(rs.next()) {
                        user.setId(rs.getInt(1));
                    }
                }

            }
        }
    }


    public User findById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        User user = new User();


        if ( null != connection ) {
            try ( PreparedStatement pst = connection.prepareStatement(FIND_BY_ID)) {
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                //int id = rs.getInt("id");
                if (rs.next()){
                    String name = rs.getString("name");
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    user = new User(id, name, login, password);
                    return user;
                }


            }

        }
        return user;

    }

    public User login(String login, String password) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        Connection connection = PersistenceManager.getConnection();
        User user = new User();

        if ( null != connection )
            try (PreparedStatement pst = connection.prepareStatement(FIND_BY_LOG_AND_PWD)) {

                pst.setString(1, login);
                //MessageDigest digest = MessageDigest.getInstance("SHA-256");
                //byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
                //pst.setString(2, hash.toString());
                pst.setString(2, password);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    user = new User(id, name, login, password);
                    return user;
                }

            }
        return user;
    }

    public static Set<User> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        Set<User> usersList = new HashSet<>();
        if ( null != connection ) {
            try ( Statement st = connection.createStatement();
                  ResultSet rs = st.executeQuery( FIND_ALL_QUERY )){
                while ( rs.next() ) {
                    int id = rs.getInt( "id" );
                    String name = rs.getString( "name" );
                    String login = rs.getString( "login" );
                    String password = rs.getString( "password" );
                    User user = new User(id, name, login, password);
                    usersList.add( user );
                }
            }
        }
        return usersList;
    }

    public User remove(int id) throws SQLException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        User user = new User();
        if ( null != connection ) {
            try ( PreparedStatement pst = connection.prepareStatement(DELETE_QUERY)) {
                pst.setInt(1, id);
                pst.executeQuery();
                //int id = rs.getInt("id");
                System.out.println("Utilisateur supprimé");




            }
        }
        return user;

    }

    public User update(int id, User user) throws SQLException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();

        if(null != connection) {
            try (PreparedStatement pst = connection.prepareStatement(UPDATE_QUERY, Statement.RETURN_GENERATED_KEYS)){

                pst.setString(1, user.getName());
                pst.setString(2, user.getLogin());
                pst.setString(3, user.getPassword());
                pst.setInt(4, id);
                pst.executeUpdate();


            }
        }
        return user;
    }

    public static DefaultTableModel get_contacts(int id, DefaultTableModel model) throws SQLException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();


        if (connection != null) {
            try (PreparedStatement pst = connection.prepareStatement("SELECT lastName, firstName, phone, type FROM contact c JOIN user_contact u ON u.idUser = ? GROUP BY c.id")
            ) {
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String phone = rs.getString("phone");
                    String type = rs.getString("type");
                    model.addRow(new Object[]{firstName, lastName, phone, type});

                }


            }
        }
        return model;

    }
}


