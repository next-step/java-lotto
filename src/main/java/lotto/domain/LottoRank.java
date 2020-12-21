package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchingCount;
    private final int prize;

    LottoRank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank findByWinningNumber(int winningNumber) {
        return Arrays.stream(values())
                .filter(r -> r.matchingCount == winningNumber)
                .findFirst()
                .orElse(MISS);
    }

}
