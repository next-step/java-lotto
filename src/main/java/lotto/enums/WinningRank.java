package lotto.enums;

import lotto.domain.MatchedCount;

import java.util.Arrays;

public enum WinningRank {
    FIRST_PLACE(new MatchedCount(6), 2_000_000_000),
    SECOND_PLACE(new MatchedCount(5), 30_000_000),
    THIRD_PLACE(new MatchedCount(5), 1_500_000),
    FOURTH_PLACE(new MatchedCount(4), 50_000),
    FIFTH_PLACE(new MatchedCount(3), 5_000),
    ETC(new MatchedCount(), 0);

    private final MatchedCount matchedCount;
    private final int prize;

    WinningRank(MatchedCount matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static WinningRank findByMacthedCount(MatchedCount matchedCount, boolean matchBonus) {

        if (FIFTH_PLACE.matchedCount().isGreaterOrEqualThan(matchedCount)) {
            return ETC;
        }

        WinningRank rank = findByMacthedCount(matchedCount);

        if (matchBonus & rank.equals(SECOND_PLACE)) {
            return SECOND_PLACE;
        }

        if (rank.equals(SECOND_PLACE)) {
            return THIRD_PLACE;
        }

        return rank;
    }

    public static WinningRank findByMacthedCount(int matchedCount, boolean matchBonus) {
        return findByMacthedCount(new MatchedCount(matchedCount), matchBonus);
    }

    private static WinningRank findByMacthedCount(MatchedCount matchedCount) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchedCount.equals(matchedCount))
                .findAny()
                .orElse(ETC);
    }

    public int prize() {
        return prize;
    }

    public MatchedCount matchedCount() {
        return matchedCount;
    }
}
