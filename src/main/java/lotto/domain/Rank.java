package lotto.domain;

import lotto.constant.Constant;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchBonus && matchCount == Constant.FIVE_AGREEMENT) {
            return SECOND;
        }

        return matchLottoPrize(matchCount);
    }

    private static Rank matchLottoPrize(int matchCount) {
        return Arrays.stream(values())
                .filter((rank) -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("실패"));
    }
}
