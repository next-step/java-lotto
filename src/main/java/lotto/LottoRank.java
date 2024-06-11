package lotto;

public enum LottoRank {
    FIRST(2000000000L),
    SECOND(30000000L),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NONE(0);

    private final long price;

    LottoRank(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
