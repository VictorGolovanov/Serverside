package repository;

import database.DBConnection;
import model.Clan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClanRepository {

    private static final String GET_CLAN_BY_ID = "select * from clans where id=";
    private static final String SAVE_CLAN = "insert into clans(name, gold) ";
    private static final String VALUES = "values";
    private static final String UPDATE_CLAN = "update clans set ";

    public Clan getClanById(long id) {
        Connection connection = DBConnection.getConnection();
        try {
            ResultSet rs = connection.createStatement().executeQuery(GET_CLAN_BY_ID + id);
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
        String sql = SAVE_CLAN + VALUES + "('" + clan.getName() + "' , " + clan.getGold() + ")";
        try {
            int result = connection.createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateClan(long id, Clan clan) {
        Connection connection = DBConnection.getConnection();
        String sql = UPDATE_CLAN + "name = " + "'" + clan.getName() + "', gold = " + clan.getGold() + " where id = " + id;
        try {
            int result = connection.createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
