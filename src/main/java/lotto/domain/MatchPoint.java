package lotto.domain;

import java.util.Arrays;

public enum MatchPoint {

    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_BONUS(5, 30_000_000),
    SIXTH(6, 2_000_000_000),
    NO_MATCH(0, 0);

    private final int match;
    private final long winningAmt;

    MatchPoint(int match, long winningAmt ) {
        this.match = match;
        this.winningAmt = winningAmt;
    }

    public static boolean isSameFIFTH_BONUS(MatchPoint matchPoint) {
        return matchPoint == FIFTH_BONUS;
    }

    public int getMatch() {
        return this.match;
    }
    public long getWinningAmt() {
        return this.winningAmt;
    }

    private boolean isSameMatchPoint(int matchPoint) {
        return this.match == matchPoint;
    }

    public static MatchPoint findMatchPoint(int matchingPoint, int bonus) {
        if(matchingPoint == 4 && bonus == 1) {
            return MatchPoint.FIFTH_BONUS;
        }
        return Arrays.stream(MatchPoint.values())
                .filter(matchPoint -> matchPoint.isSameMatchPoint(matchingPoint))
                .findFirst()
                .orElse(NO_MATCH);
    }
}
