package lotto.domain.prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoPrize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private static final Map<Integer, Map<Boolean, LottoPrize>> LOTTO_PRIZES;
    private static final int NOTHING_INDEX = 0;

    private final int match;
    private final long prize;
    private final boolean isBonus;

    static {
        LOTTO_PRIZES = new HashMap<>();
        for (LottoPrize lottoPrize : values()) {
            LOTTO_PRIZES.computeIfAbsent(lottoPrize.match, HashMap::new).put(lottoPrize.isBonus, lottoPrize);
        }
    }

    LottoPrize(int match, long prize) {
        this(match, prize, false);
    }

    LottoPrize(int match, long prize, boolean isBonus) {
        this.isBonus = isBonus;
        this.match = match;
        this.prize = prize;
    }

    public static LottoPrize from(int match, boolean hasBonus) {
        Map<Boolean, LottoPrize> matchedPrizes = LOTTO_PRIZES.getOrDefault(match, LOTTO_PRIZES.get(NOTHING_INDEX));
        return matchedPrizes.containsKey(true) ? matchedPrizes.get(hasBonus) : matchedPrizes.get(false);
    }

    public long prize(int quantity) {
        return prize * quantity;
    }

    public int getMatch() {
        return match;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
