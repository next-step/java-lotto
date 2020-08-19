package cc.oakk.lotto;

import java.util.HashMap;
import java.util.Map;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class SimpleLottoPrizeProvider implements LottoPrizeProvider<Long> {
    private static final Map<Rank, Long> prizes;

    static {
        prizes = new HashMap<>();
        prizes.put(Rank.FIRST, 2000000000L);
        prizes.put(Rank.SECOND, 1500000L);
        prizes.put(Rank.THIRD, 50000L);
        prizes.put(Rank.FOURTH, 5000L);
    }

    public Long getPrizeByRank(Rank rank) {
        return prizes.getOrDefault(throwIfNull(rank), 0L);
    }
}
