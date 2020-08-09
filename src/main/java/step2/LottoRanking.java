package step2;

/**
 * 당첨 관련된 상수 정의 Enum
 */
public enum LottoRanking {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3);

    // 당첨금
    private int prizeMoney;

    // 당첨 숫자 갯수
    private int hitCount;

    LottoRanking(int prizeMoney, int hitCount) {
        this.prizeMoney = prizeMoney;
        this.hitCount = hitCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getPrizeMoney(int count) {
        return prizeMoney * count;
    }

    public int getHitCount() {
        return hitCount;
    }
}