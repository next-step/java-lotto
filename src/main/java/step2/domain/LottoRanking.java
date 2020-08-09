package step2.domain;

/**
 * 당첨 관련된 상수 정의 Enum
 */
public enum LottoRanking {
    FOURTH(5000, 3),
    THIRD(50000, 4),
    SECOND(1500000, 5),
    FIRST(2000000000, 6);

    // 당첨금
    private int prizeMoney;

    // 당첨 숫자 갯수
    private int matchCount;

    LottoRanking(int prizeMoney, int matchCount) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}