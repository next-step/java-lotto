package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSE(0, 0);

    private final int matchNumberCount;
    private final int prize;

    Rank(int matchNumberCount, int prize) {
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank getRank(int count) {
        return Arrays.stream(values())
                .filter(r -> r.matchNumberCount == count)
                .findAny()
                .orElse(LOSE);
    }

}
