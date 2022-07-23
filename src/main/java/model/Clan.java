package model;

import lombok.Getter;

@Getter
public class Clan {

    private long id;
    private String name;
    private int gold;

    public Clan(long id, String name, int gold) {
        this.id = id;
        this.name = name;
        this.gold = gold;
    }

    public Clan(String name, int gold) {
        this.name = name;
        this.gold = gold;
    }

    public void incGold(int amount) {
        this.gold += amount;
    }
}
