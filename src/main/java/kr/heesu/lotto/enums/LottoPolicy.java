package kr.heesu.lotto.enums;

public enum LottoPolicy {
    THREE_MATCHES(3L, 5000L),
    FOUR_MATCHES(4L, 50000L),
    FIVE_MATCHES(5L, 1500000L),
    SIX_MATCHES(6L, 2000000000L);

    private final Long count;
    private final Long price;

    LottoPolicy(Long count, Long price) {
        this.count = count;
        this.price = price;
    }

    public Long getCount() {
        return count;
    }

    public Long getPrice() {
        return price;
    }
}
