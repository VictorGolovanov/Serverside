package manager;

import repository.TrackerRepository;

public class TrackerManager {

    public static boolean trackerClanGold(long clanId, long userId, int gold) {
        return TrackerRepository.trackerClanGold(clanId, userId, gold);
    }
}
