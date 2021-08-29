package lotto.ticket;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public enum Prize {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    LOSER(0, 0);

    private final int prizeMoney;
    private final int winningNumbersCounts;

    Prize(int prizeMoney, int winningNumbersCounts) {
        this.prizeMoney = prizeMoney;
        this.winningNumbersCounts = winningNumbersCounts;
    }

    public static Prize prize(int winningNumberCount) {
        Optional<Prize> result = Arrays.stream(Prize.values())
                .filter(has(winningNumberCount)).findFirst();
        return result.orElse(LOSER);
    }

    private static Predicate<Prize> has(int winningNumberCount) {
        return prize -> prize.winningNumbersCount() == winningNumberCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public int winningNumbersCount() {
        return winningNumbersCounts;
    }
}
