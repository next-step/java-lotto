package lotto.domain;

public class RateOfReturn {
    private final Money investment;
    private final Money income;

    public RateOfReturn(Money investment, Money income) {
        if (investment.isZero()) {
            throw new IllegalArgumentException("The investment must be greater than zero.");
        }
        this.investment = investment;
        this.income = income;
    }

    public double value() {
        return Math.round((float)(income.value() / (double) investment.value()) * 100) / 100.0;
    }
}
