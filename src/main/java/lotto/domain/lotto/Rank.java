package lotto.domain.lotto;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(150_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private static final int SECOND_MATCHES = 5;

    private final int prize;
    private final int matches;

    Rank(final int prize, final int matches) {
        this.prize = prize;
        this.matches = matches;
    }

    public static Rank getRank(final int matches, final boolean hasBonus) {
        if (matches == SECOND_MATCHES && hasBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(prize -> prize.isMatches(matches))
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatches() {
        return matches;
    }

    private boolean isMatches(final int count) {
        return matches == count;
    }
}
