package lotto;

import java.util.Arrays;

import static lotto.MatchStatus.*;

public enum Rank {
    FIRST(6, INCONCLUSIVE, 2_000_000_000),
    SECOND(5, MATCHED, 30_000_000),
    THIRD(5, UNMATCHED, 1_500_000),
    FOURTH(4, INCONCLUSIVE, 50_000),
    FIFTH(3, INCONCLUSIVE, 5_000),
    MISS(0, INCONCLUSIVE, 0);

    private final long matchCount;
    private final MatchStatus matchStatus;
    private final int prize;

    Rank(long matchCount, MatchStatus matchStatus, int prize) {
        this.matchCount = matchCount;
        this.matchStatus = matchStatus;
        this.prize = prize;
    }

    public static Rank valueOf(long matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && matchBonus(rank.matchStatus, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean matchBonus(MatchStatus matchStatus, boolean matchBonus) {
        if (matchStatus == INCONCLUSIVE) {
            return true;
        }

        if (matchStatus == MATCHED) {
            return matchBonus;
        }

        // UNMATCHED
        return !matchBonus;
    }

    public int getPrize() {
        return prize;
    }
}
