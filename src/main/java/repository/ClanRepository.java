package repository;

import database.DBConnection;
import model.Clan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DBStrings.*;

public class ClanRepository {

    public Clan getClanById(long id) {
        Connection connection = DBConnection.getConnection();
        try {
            ResultSet rs = connection.createStatement()
                    .executeQuery(String.format(GET_CLAN_BY_ID, CLAN_TABLE) + id);
            if (rs.next()) {
                String name = rs.getString("name");
                int gold = rs.getInt("gold");
                rs.close();
                return new Clan(id, name, gold);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveClan(Clan clan) {
        if (clan == null || clan.getName().isEmpty()) {
            return false;
        }
        Connection connection = DBConnection.getConnection();
        String sql = String.format(SAVE_CLAN, CLAN_TABLE) +
                VALUES + "('" + clan.getName() + "' , " + clan.getGold() + ")";
        try {
            int result = connection.createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateClanById(long id, Clan clan) {
        Connection connection = DBConnection.getConnection();
        String sql = String.format(UPDATE_CLAN, CLAN_TABLE) +
                "name = " + "'" + clan.getName() + "', gold = " + clan.getGold() + " where id = " + id;
        try {
            int result = connection.createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
