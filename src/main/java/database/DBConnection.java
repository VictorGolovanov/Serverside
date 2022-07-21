package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    private static final String URl = "jdbc:mysql://localhost:3306/skytec";
    private static final String dbUser = "admin";
    private static final String dbPassword = "password";

    public static Connection getConnection() {
        if (connection == null) {
            try{
                connection = DriverManager.getConnection(URl +"?user=" + dbUser + "&password=" + dbPassword);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
    //todo getConnection with table creating
}
