package cc.oakk.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoPrizeProvider {
    private static Map<Rank, Long> prizes;

    static {
        prizes = new HashMap<>();
        prizes.put(Rank.FIRST, 2000000000L);
        prizes.put(Rank.SECOND, 1500000L);
        prizes.put(Rank.THIRD, 50000L);
        prizes.put(Rank.FOURTH, 5000L);
    }

    public static long getPrizeByRank(Rank rank) {
        if (rank == null) {
            throw new IllegalArgumentException("Rank is null!");
        }
        return prizes.getOrDefault(rank, 0L);
    }
}
