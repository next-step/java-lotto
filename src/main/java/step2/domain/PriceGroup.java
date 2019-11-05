package step2.domain;

import java.util.Arrays;

public enum PriceGroup {
    THREE(3, 5_000L),
    FOUR(4, 50_000L),
    FIVE(5, 1_500_000L),
    FIVE_WITH_BONUS(5, 30_000_000L),
    SIX(6, 2_000_000_000L),
    ZERO(0, 0L);

    private Integer matchAmount;
    private Long price;

    PriceGroup(Integer matchAmount, Long price) {
        this.matchAmount = matchAmount;
        this.price = price;
    }

    public static PriceGroup findPriceByMatchAmount(int matchAmount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(priceGroup -> priceGroup.isEqual(matchAmount, hasBonus))
                .findFirst()
                .orElse(ZERO);
    }

    private boolean isEqual(int matchAmount, boolean hasBonus) {
        if (isFive(matchAmount)) {
            return !hasBonus;
        }
        return this.matchAmount == matchAmount;
    }

    private boolean isFive(int matchAmount) {
        return (this.equals(PriceGroup.FIVE) && (matchAmount == PriceGroup.FIVE.matchAmount));
    }

    public Integer getMatchAmount() {
        return matchAmount;
    }

    public Long getPrice() {
        return price;
    }
}
