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
                generateAndFillTables();
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    private static void generateAndFillTables() throws SQLException {
        connection.createStatement().execute("drop table if exists clans");

        connection.createStatement().execute("create table clans(" +
                "id int not null auto_increment," +
                "name varchar(45) not null," +
                "gold int not null default '0'," +
                "primary key (id)," +
                "unique index id_unique (id asc) visible," +
                "unique index name_unique (name asc) visible);");

        connection.createStatement().execute("drop table if exists trackers");

        connection.createStatement().execute("create table trackers(" +
                "id int not null auto_increment," +
                "clan_id int not null," +
                "user_id int not null," +
                "gold int not null default '0'," +
                "primary key (id)," +
                "unique index id_unique(id asc) visible);");

        connection.createStatement().execute("insert into clans(name, gold) " +
                "values " +
                "('BigBrothers', 1532)," +
                "('StarWars', 1000)," +
                "('Alatriste', 2341)," +
                "('Winter is coming', 543);");

        connection.createStatement().execute("insert into clans(name) " +
                "values" +
                "('Jon Sneg')," +
                "('Mothers of Dragons')," +
                "('Mary Sew');");
    }
}
