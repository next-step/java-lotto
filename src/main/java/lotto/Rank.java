package lotto;

import java.util.Arrays;

public enum Rank {

    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int winnings;

    Rank(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Rank findRank(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("0 ~ 6이외의 matchCount 는 발생할 수 없습니다."));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }
}
