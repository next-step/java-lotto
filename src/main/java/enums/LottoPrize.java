package enums;

import lotto.domain.Money;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private int matchCount;
    private double prize;
    private boolean bonus;

    LottoPrize(int matchCount, boolean bonus, double prize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getWinningPrize(int ticketCount) {
        return new Money(prize * ticketCount);
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
