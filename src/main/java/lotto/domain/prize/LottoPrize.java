package lotto.domain.prize;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    private static final Map<Integer, LottoPrize> LOTTO_PRIZES;

    private final int match;
    private final int prize;

    static {
        LOTTO_PRIZES = new HashMap<>();

        for (LottoPrize lottoPrize : values()) {
            LOTTO_PRIZES.put(lottoPrize.match, lottoPrize);
        }
    }

    LottoPrize(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoPrize from(int match) {
        return LOTTO_PRIZES.getOrDefault(match, NOTHING);
    }

    public int prize(int quantity) {
        return prize * quantity;
    }

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }
}
