package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, false),
    FIFTH(3, 5_000L, false),
    LOSE(0, 0L, false);

    private final int matchNumberCount;
    private final Long prize;
    private final boolean isMatchBonus;

    Rank(int matchNumberCount, Long prize, boolean isMatchBonus) {
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
        this.isMatchBonus = isMatchBonus;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public Long getPrize() {
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
