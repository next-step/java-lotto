package enums;

import lotto.domain.Money;

import java.util.function.Function;

public enum LottoPrize {

    FIRST(6, 2_000_000_000, (count) -> 2_000_000_000d * count),
    SECOND(5, 30_000_000, (count) -> 30_000_000d * count),
    THIRD(5, 1_500_000, (count) -> 1_500_000d * count),
    FOURTH(4, 50_000, (count) -> 50_000d * count),
    FIFTH(3, 5_000, (count) -> 5_000d * count),
    MISS(0, 0, (count) -> 0d * count);

    private int matchCount;
    private double prize;
    private Function<Integer, Double> calculate;

    LottoPrize(int matchCount, double prize, Function<Integer, Double> calculate) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.calculate = calculate;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getWinningPrize(int count) {
        return new Money(calculate.apply(count));

    }
}
