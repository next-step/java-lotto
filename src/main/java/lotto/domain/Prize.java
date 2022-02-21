package lotto.domain;

public class Prize {

    private final Money value;

    public Prize(Money value) {
        this.value = value;
    }

    public double getPrizeRatio(final RankResult rankResult, final Money money) {
        return getTotalPrize(rankResult) / (double) money.getValue();
    }

    public int getTotalPrize(final RankResult rankResult) {
        return rankResult.getTotalPrize();
    }

    public Money getValue() {
        return value;
    }
}
