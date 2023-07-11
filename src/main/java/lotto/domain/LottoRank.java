package lotto.domain;

public enum LottoRank {
    FIRST(2_000_000_000L),
    SECOND(30_000_000L),
    THIRD(1_500_000L),
    FOURTH(50_000L),
    FIFTH(5_000L),
    NONE(0L);

    private final long price;

    LottoRank(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
