package lotto.enums;

/**
 * SECOND의 경우 보너스 번호가 일치해야 하는 특수한 경우이므로
 * 보너스 번호가 일치할 경우 matchCount를 10으로 두고 SECOND의 matchCount를 15 (5 + 10)로 지정한다.
 */
public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(15, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    public static final int BONUS_NUMBER_MATCH_COUNT = 10;

    private int matchCount;
    private long prizeMoney;

    LottoRank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
