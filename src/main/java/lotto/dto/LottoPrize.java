package lotto.dto;

import lotto.domain.Match;

import java.util.Arrays;

public enum LottoPrize {

    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final long prize;

    LottoPrize(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize of(int count) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == count)
                .findFirst()
                .orElse(null);
    }

    public static LottoPrize from(Match match) {
        return of(match.getCount());
    }

    public long getPrize() {
        return prize;
    }
}
