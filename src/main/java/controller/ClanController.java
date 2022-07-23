package controller;

import service.ClanService;

public class ClanController {

    ClanService clanService = new ClanService();

    public void incGold(long clanId, long userId, int gold) {
        clanService.incGold(clanId, userId, gold);
    }
}
