package service;

import com.google.common.util.concurrent.Striped;
import manager.ClanManager;
import manager.TrackerManager;
import model.Clan;

import java.util.concurrent.locks.Lock;

public class ClanService {

    @SuppressWarnings("UnstableApiUsage")
    private final Striped<Lock> lockStriped = Striped.lazyWeakLock(100);

    @SuppressWarnings("UnstableApiUsage")
    public void incGold(long clanId, long userId, int gold) {
        Lock lock = lockStriped.get(clanId);
        lock.lock();
        try {
            Clan clan = ClanManager.getClan(clanId);
            if (clan != null) {
                clan.incGold(gold);
                boolean clanResult = ClanManager.updateClanById(clanId, clan);
                if (!clanResult) {
                    throw new RuntimeException("clan update failed");
                }
                boolean trackerResult = TrackerManager.trackerClanGold(clanId, userId, gold);
                if (!trackerResult) {
                    throw new RuntimeException("tracker update failed");
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
