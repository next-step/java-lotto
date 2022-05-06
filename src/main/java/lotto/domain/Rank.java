package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    LOSE(0, 0, false);

    private final int matchNumberCount;
    private final int prize;
    private final boolean isMatchBonus;

    Rank(int matchNumberCount, int prize, boolean isMatchBonus) {
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
        this.isMatchBonus = isMatchBonus;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank getRank(int count, boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(r -> r.matchNumberCount == count)
                .filter(r -> r.isMatchBonus == isMatchBonus)
                .findAny()
                .orElse(LOSE);
    }
}
