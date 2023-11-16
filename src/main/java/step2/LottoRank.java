package step2;

public enum LottoRank {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5,1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3, 5_000),
    NO_PRIZE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }
}
