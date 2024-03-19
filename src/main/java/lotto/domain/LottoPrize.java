package lotto.domain;

import java.util.*;

public enum LottoPrize {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000)
    ;

    private final int matchCount;
    private final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    private static final Map<Integer, LottoPrize> prizeMap = new HashMap<>();
    static {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeMap.put(prize.matchCount, prize);
        }
    }

    public static List<LottoPrize> getLottoPrizes() {
        return List.of(LottoPrize.values());
    }

    public static int getPrize(LottoPrize prize) {
        return prize.prize;
    }

    public static LottoPrize lookup(int matchCount) {
        return prizeMap.get(matchCount);
    }

    public static int getMatchCount(LottoPrize prizes) {
        return prizes.matchCount;
    }

}
