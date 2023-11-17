package lotto.domain;

import java.util.Arrays;

public enum Match {

    THREEMATCH(3, 5000),
    FOURMATCH(4, 50000),
    FIVEMATCH(5, 1500000),
    SIXMATCH(6, 2000000000),
    BLANK(0, 0);

    private final int matchCount;
    private final int prize;

    Match(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int prize() {
        return prize;
    }

    public static Match valueOf(Lotto lotto) {
        return lotto.getMatch();
    }

    public static Match valueOf(int count) {
        return Arrays.stream(values())
                .filter(m -> m.matchCount == count)
                .findFirst()
                .orElse(BLANK);
    }
}
