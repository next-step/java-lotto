package cc.oakk.lotto.model;

import java.util.HashMap;
import java.util.Map;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class SimpleLottoPrizeProvider implements LottoPrizeProvider<Long> {
    private static final Map<Rank, LottoPrize<Long>> prizes;
    private static final LottoPrize<Long> DEFAULT_PRIZE = new MoneyPrize(0L);

    static {
        prizes = new HashMap<>();
        prizes.put(Rank.FIRST, new MoneyPrize(2000000000L));
        prizes.put(Rank.SECOND, new MoneyPrize(1500000L));
        prizes.put(Rank.THIRD, new MoneyPrize(50000L));
        prizes.put(Rank.FOURTH, new MoneyPrize(5000L));
    }

    public LottoPrize<Long> getPrizeByRank(Rank rank) {
        return prizes.getOrDefault(throwIfNull(rank), DEFAULT_PRIZE);
    }
}
