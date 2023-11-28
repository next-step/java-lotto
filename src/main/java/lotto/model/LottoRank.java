package lotto.model;

public enum LottoRank {

    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    BLANK(0, 0);


    private final long rank;
    private final int money;

    LottoRank(long rank, int money) {
        this.rank = rank;
        this.money = money;
    }

    public int money() {
        return this.money;
    }

    public long rank() {
        return this.rank;
    }

}
