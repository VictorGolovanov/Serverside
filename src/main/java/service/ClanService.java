package service;

import com.google.common.util.concurrent.Striped;
import manager.ClanManager;
import model.Clan;

import java.util.concurrent.locks.Lock;

public class ClanService {

    @SuppressWarnings("UnstableApiUsage")
    private final Striped<Lock> lockStriped = Striped.lock(100);

    @SuppressWarnings("UnstableApiUsage")
    public void incGold(long clanId, int gold) {
        Lock lock = lockStriped.get(clanId);
        lock.lock();
        Clan clan = ClanManager.getClan(clanId);
        if (clan != null) {
            clan.incGold(gold);
            boolean result =  ClanManager.updateClan(clanId, clan);
            if (!result) {
                throw new RuntimeException("update failed");
            }
        }
        lock.unlock();
    }
}
