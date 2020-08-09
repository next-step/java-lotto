package step2;

public enum LottoRanking {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3);

    private int prizeMoney;
    private int hitCount;

    LottoRanking(int prizeMoney, int hitCount) {
        this.prizeMoney = prizeMoney;
        this.hitCount = hitCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getHitCount() {
        return hitCount;
    }
}