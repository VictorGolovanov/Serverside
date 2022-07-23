package repository;

import database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

import static database.DBStrings.*;

public class TrackerRepository {

    public static boolean trackerClanGold(long clanId, long userId, int gold) {
        Connection connection = DBConnection.getConnection();
        String sql = String
                .format(SAVE_TRACKER, TRACKERS_TABLE) + VALUES + "(" + clanId + ", " + userId + ", " + gold + ")";
        try {
            int result = connection.createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
