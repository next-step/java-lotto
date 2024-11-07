package lotto.entity;

import java.util.Arrays;

public enum PrizePolicy {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
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

    public boolean match(int matchCount) {
        return this.matchCount == matchCount;
    }

    public static PrizePolicy fromMatchCount(int matchCount) {
        return Arrays.stream(PrizePolicy.values())
                .filter(prizePolicy -> prizePolicy.match(matchCount))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 매칭 숫자: " + matchCount));
    }

    public static PrizePolicy fromMatchCountAndBonus(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return FIVE_BONUS;
        }
        return fromMatchCount(matchCount);
    }
}
