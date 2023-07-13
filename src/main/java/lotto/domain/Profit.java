package lotto.domain;

public class Profit {

    private final double profitRate;

    public Profit(Money principal, Money profit) {
        validateNotZeroDominator(principal);
        this.profitRate = principal.profitRate(profit);
    }

    private void validateNotZeroDominator(Money dominator) {
        if (dominator.isZero()) {
            throw new IllegalArgumentException("원금은 0일 수 없습니다.");
        }
    }

    public double getProfitRate() {
        return profitRate;
    }
}
