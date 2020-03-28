package enums;

import lotto.domain.Money;

import java.util.function.Function;

public enum LottoPrize {
    MATCH3(5000, (count) -> 5000.0 * count),
    MATCH4(50000, (count) -> 50000.0 * count),
    MATCH5(1500000, (count) -> 1500000.0 * count),
    MATCH6(2000000000, (count) -> 2000000000.0 * count);

    private double prize;
    private Function<Integer, Double> calculate;

    LottoPrize(double prize, Function<Integer, Double> calculate) {
        this.prize = prize;
        this.calculate = calculate;
    }

    public Money calculate(int count) {
        return new Money(calculate.apply(count));

    }
}
