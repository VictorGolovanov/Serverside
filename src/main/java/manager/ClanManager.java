package manager;

import model.Clan;
import repository.ClanRepository;

public class ClanManager {

    private static final ClanRepository clanRepository = new ClanRepository();

    public static Clan getClan(long id) {
        return clanRepository.getClanById(id);
    }

    // for standard logic
    public static boolean saveClan(Clan clan) {
        return clanRepository.saveClan(clan);
    }

    public static boolean updateClan(long clanId, Clan clan) {
        return clanRepository.updateClan(clanId, clan);
    }
}
