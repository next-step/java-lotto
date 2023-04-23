package step2;

public enum LottoRank {

    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_SIX(6, 2000000000);

    private final int countOfMatch;

    private final long prizeAmount;

    LottoRank(int countOfMatch, long prizeAmount) {
        this.countOfMatch = countOfMatch;
        this.prizeAmount = prizeAmount;
    }

    public int countOfMatch() {
        return countOfMatch;
    }

    public long prizeAmount() {
        return prizeAmount;
    }
}
