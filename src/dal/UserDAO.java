package dal;

import bo.Contact;
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
    private static final String FIND_BY_LOG_AND_PWD = "SELECT * FROM user WHERE login = ? AND password = ?";


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

    public static DefaultTableModel get_contacts(int id, DefaultTableModel model) throws SQLException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();


        if (connection != null) {
            try (PreparedStatement pst = connection.prepareStatement("SELECT id, lastName, firstName, phone, type FROM contact c JOIN user_contact u ON u.idUser = ? GROUP BY c.id")
            ) {
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    int idContact = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String phone = rs.getString("phone");
                    String type = rs.getString("type");
                    model.addRow(new Object[]{idContact, lastName, firstName, phone, type});

                }


            }
        }
        return model;

    }

    public static void create(Contact contact) throws SQLException, ClassNotFoundException{
        Connection connection = PersistenceManager.getConnection();
        if(connection != null){
            try(PreparedStatement pst = connection.prepareStatement("INSERT INTO contact (lastName, firstName, phone, type) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)){
                pst.setString(1, contact.getLastName());
                pst.setString(2, contact.getFirstName());
                pst.setString(3, contact.getPhone());
                pst.setString(4, contact.getType());
                pst.executeUpdate();
                try(ResultSet rs = pst.getGeneratedKeys()){
                    if(rs.next()){
                        contact.setId(rs.getInt(1));
                    }
                }
            }

        }
    }

    public static void remove(int contact) throws SQLException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        User user = new User();
        if ( null != connection ) {
            try ( PreparedStatement pst = connection.prepareStatement("DELETE FROM contact WHERE id = ?")){
                pst.setInt(1, contact);
                pst.executeQuery();
            }
        }
    }
}


