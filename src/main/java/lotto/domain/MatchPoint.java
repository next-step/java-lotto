package lotto.domain;

public enum MatchPoint {

    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    SIXTH(6, 2000000000);

    private final int match;
    private final long winningAmt;

    MatchPoint(int match, long winningAmt) {
        this.match = match;
        this.winningAmt = winningAmt;
    }

    public int getMatch() {
        return this.match;
    }

    public long getWinningAmt() {
        return this.winningAmt;
    }

    public boolean comparePoint(int matchPoint) {
        if (this.match == matchPoint) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return match + "개 일치" + "(" + winningAmt + "원)-";
    }
}
