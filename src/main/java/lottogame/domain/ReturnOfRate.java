package lottogame.domain;

public class ReturnOfRate {

    private static final Double min_profit_range = Double.from(1.0);

    private final Double value;

    private ReturnOfRate(Double value) {
        this.value = value;
    }

    public static ReturnOfRate fromDouble(Double value) {
        return new ReturnOfRate(value);
    }

    public boolean isProfitRange() {
        return value.isMoreThen(min_profit_range);
    }

    public double toTwoDecimal() {
        return value.toTwoDecimal();
    }
}
