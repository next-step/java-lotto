package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount < 3) {
            return NONE;
        }

        return matchLottoPrize(matchCount);
    }

    private static Rank matchLottoPrize(int matchCount) {
        return Arrays.stream(values())
                .filter((rank) -> rank.matchCount == matchCount && rank != SECOND)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("로또는 적어도 3개 이상 일치해야 합니다."));
    }

}
