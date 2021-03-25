package lotto.domain;

public enum LottoRank {
    ONE(6, 2000000000),
    THREE(5, 1500000),
    FOUR(4, 50000),
    FIVE(5, 5000)
    ;

    private final int matchCount;
    private final long winAmount;

    LottoRank(int matchCount, long winAmount) {
        this.matchCount = matchCount;
        this.winAmount = winAmount;
    }
}
