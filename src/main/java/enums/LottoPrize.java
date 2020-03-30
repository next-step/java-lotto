package enums;

import lotto.domain.Money;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoPrize {

    FIRST(6, false, 2_000_000_000, (ticketCount) -> 2_000_000_000d * ticketCount),
    SECOND(5, true, 30_000_000, (ticketCount) -> 30_000_000d * ticketCount),
    THIRD(5, false, 1_500_000, (ticketCount) -> 1_500_000d * ticketCount),
    FOURTH(4, false, 50_000, (ticketCount) -> 50_000d * ticketCount),
    FIFTH(3, false, 5_000, (ticketCount) -> 5_000d * ticketCount),
    MISS(0, false, 0, (ticketCount) -> 0d * ticketCount);

    private int matchCount;
    private double prize;
    private boolean bonus;
    private Function<Integer, Double> getWinPrize;

    LottoPrize(int matchCount, boolean bonus, double prize, Function<Integer, Double> getWinPrize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
        this.getWinPrize = getWinPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getWinningPrize(int ticketCount) {
        return new Money(getWinPrize.apply(ticketCount));
    }

    public static LottoPrize findRank(int matchCount, boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(x -> x.matchCount == matchCount)
                .filter(x -> x.bonus == bonusNumber)
                .findFirst()
                .orElse(MISS);
    }

    public boolean isEquals(LottoPrize that) {
        return this.name().equals(that.name());
    }
}
