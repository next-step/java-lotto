package lotto.domain;

import java.util.*;

public enum LottoPrize {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000)
    ;

    public static final int NUMBER_INDEX_FROM = 0;
    public static final int NUMBER_INDEX_TO = 6;

    private final int matchCount;
    private final int winAmount;

    LottoPrize(int matchCount, int winAmount) {
        this.matchCount = matchCount;
        this.winAmount = winAmount;
    }

    private static final Map<Integer, LottoPrize> matchAmountMap = new HashMap<>();
    static {
        for (LottoPrize prize : LottoPrize.values()) {
            matchAmountMap.put(prize.matchCount, prize);
        }
    }

    public static List<LottoPrize> getLottoPrizes() {
        return List.of(LottoPrize.values());
    }

    public static int getWinAmount(LottoPrize prizes) {
        return prizes.winAmount;
    }

    public static LottoPrize lookup(int matchCount) {
        return matchAmountMap.get(matchCount);
    }

    public static int getMatchCount(LottoPrize prizes) {
        return prizes.matchCount;
    }

}
