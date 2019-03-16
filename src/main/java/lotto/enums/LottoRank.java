package lotto.enums;

public enum LottoRank {
    FIRST(6, 5_000),
    SECOND(5, 50_000),
    THIRD(4, 1_500_000),
    FOURTH(3, 2_000_000_000);

    private int matchCount;
    private int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
