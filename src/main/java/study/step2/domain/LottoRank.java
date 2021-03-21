package study.step2.domain;

public enum LottoRank {
    MISS(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int amount;
    private final int hit;

    LottoRank(int hit, int amount) {
        this.hit = hit;
        this.amount = amount;
    }

    public static LottoRank of(int hit) {
        return null;
    }

}
