package step2.domain;

import java.util.Arrays;

public enum PriceGroup {
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    SIX(6, 2000000000L),
    ZERO(0, 0L);

    private Integer matchAmount;
    private Long price;

    PriceGroup(Integer matchAmount, Long price) {
        this.matchAmount = matchAmount;
        this.price = price;
    }

    public static PriceGroup findPriceByMatchAmount(int matchAmount) {
        return Arrays.stream(values())
                .filter(priceGroup -> priceGroup.isEqual(matchAmount))
                .findFirst()
                .orElse(ZERO);
    }

    private boolean isEqual(int matchAmount) {
        return this.matchAmount == matchAmount;
    }

    public Integer getMatchAmount() {
        return matchAmount;
    }

    public Long getPrice() {
        return price;
    }
}
