package lotto.domain;

import java.util.Arrays;

public enum MatchPoint {

    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    SIXTH(6, 2000000000),
    NO_MATCH(0, 0);

    private final int match;
    private final long winningAmt;

    MatchPoint(int match, long winningAmt) {
        this.match = match;
        this.winningAmt = winningAmt;
    }

    public long getWinningAmt() {
        return this.winningAmt;
    }

    private boolean isSameMatchPont(int matchPoint) {
        return this.match == matchPoint;
    }

    public static MatchPoint findMatchPoint(int matchingPoint) {
        return Arrays.stream(MatchPoint.values())
                .filter(matchPoint -> matchPoint.isSameMatchPont(matchingPoint))
                .findFirst()
                .orElse(NO_MATCH);
    }

    @Override
    public String toString() {
        return match + "개 일치" + "(" + winningAmt + "원)-";
    }
}
