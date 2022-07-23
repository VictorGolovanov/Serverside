package database;

public class DBStrings {

    public static final String CLAN_TABLE = "clans";
    public static final String GET_CLAN_BY_ID = "select * from %s where id=";
    public static final String SAVE_CLAN = "insert into %s(name, gold) ";
    public static final String VALUES = "values";
    public static final String UPDATE_CLAN = "update %s set ";
    public static final String TRACKERS_TABLE = "trackers";
    public static final String SAVE_TRACKER = "insert into %s(clan_id, user_id, gold) ";

}
