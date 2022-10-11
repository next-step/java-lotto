package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPrize {

    THREE(3, new Money(5000)),
    FOUR(4, new Money(50000)),
    FIVE(5, new Money(1500000)),
    SIX(6, new Money(2000000000))
    ;

    private final int count;
    private final Money prizeMoney;

    WinningPrize(int count, Money prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public static Optional<WinningPrize> findWinningPrize(int count) {
        return Arrays.stream(WinningPrize.values())
                .filter(winningPrize -> winningPrize.count == count)
                .findFirst();
    }
}
