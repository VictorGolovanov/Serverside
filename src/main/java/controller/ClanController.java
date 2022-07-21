package controller;

import service.ClanService;

public class ClanController {

    ClanService clanService = new ClanService();

    public void incGold(long clanId, int gold) {
        clanService.incGold(clanId, gold);
    }
}
