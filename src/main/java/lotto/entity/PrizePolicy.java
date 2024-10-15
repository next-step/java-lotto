package lotto.entity;

import java.util.Arrays;

public enum PrizePolicy {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    PrizePolicy(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

//    public static int fromMatchCount(int matchCount) {
//        return Arrays.stream(PrizePolicy.values())
//                .filter(prizePolicy -> prizePolicy.getMatchCount() == matchCount)
//                .findFirst()
//                .map(PrizePolicy::getPrize)
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 매칭 숫자: " + matchCount));
//    }
    public static PrizePolicy fromMatchCount(int matchCount) {
        return Arrays.stream(PrizePolicy.values())
                .filter(prizePolicy -> prizePolicy.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 매칭 숫자: " + matchCount));
    }
}
