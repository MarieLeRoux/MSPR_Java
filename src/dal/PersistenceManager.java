package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistenceManager {
    private static Connection connection;
    private PersistenceManager() {}
    private static final String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost/segabank";
    private static final String DB_LOGIN = "root";
    private static final String DB_PWD = "root";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(null == connection || connection.isClosed()) {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if(null != connection && !connection.isClosed()){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("oupsi");
                throw e;
            }
        }
    }
}
