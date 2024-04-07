package lottogame.domain;

public class Rate {

    private static final Double min_profit_range = Double.from(1.0);

    private final Double value;

    private Rate(Double value) {
        this.value = value;
    }

    public static Rate fromDouble(Double value) {
        return new Rate(value);
    }

    public boolean isProfitRange() {
        return value.isMoreThen(min_profit_range);
    }

    public double toTwoDecimal() {
        return value.toTwoDecimal();
    }
}
