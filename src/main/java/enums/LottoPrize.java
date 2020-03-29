package enums;

import lotto.domain.Money;

import java.util.function.Function;

public enum LottoPrize {

    FIRST(6, false, 2_000_000_000, (count) -> 2_000_000_000d * count),
    SECOND(5, true, 30_000_000, (count) -> 30_000_000d * count),
    THIRD(5, false, 1_500_000, (count) -> 1_500_000d * count),
    FOURTH(4, false, 50_000, (count) -> 50_000d * count),
    FIFTH(3, false, 5_000, (count) -> 5_000d * count),
    MISS(0, false, 0, (count) -> 0d * count);

    private int matchCount;
    private double prize;
    private boolean bonus;
    private Function<Integer, Double> calculate;

    LottoPrize(int matchCount, boolean bonus, double prize, Function<Integer, Double> calculate) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
        this.calculate = calculate;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getWinningPrize(int count) {
        return new Money(calculate.apply(count));
    }

    public static LottoPrize findRank(int matchCount, boolean bonusNumber) {
        for (LottoPrize val : values()) {
            if ((matchCount == val.matchCount) && (bonusNumber == val.bonus)) {
                return val;
            }
        }
        return MISS;
    }

    public boolean isEquals(LottoPrize that) {
        return this.name().equals(that.name());
    }
}
