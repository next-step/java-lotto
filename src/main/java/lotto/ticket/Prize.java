package lotto.ticket;

import java.util.Arrays;
import java.util.Optional;

public enum Prize {
    FIRST(2000000000, 6, 0),
    SECOND(30000000, 5, 1),
    THIRD(1500000, 5, 0),
    FOURTH(50000, 4, 0),
    FIFTH(5000, 3, 0),
    LOSER(0, 0, 0);

    private final int prizeMoney;
    private final int winningNumbersCounts;
    private final int bonusNumber;

    Prize(int prizeMoney, int winningNumbersCounts, int bonusNumber) {
        this.prizeMoney = prizeMoney;
        this.winningNumbersCounts = winningNumbersCounts;
        this.bonusNumber = bonusNumber;
    }

    public static Prize prize(int winningNumberCount, int bonusNumber) {
        Optional<Prize> result = Arrays.stream(Prize.values())
                .filter(prize -> prize.winningNumbersCounts == winningNumberCount)
                .filter(prize -> prize.bonusNumber == bonusNumber)
                .findFirst();
        return result.orElse(LOSER);
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public int winningNumbersCount() {
        return winningNumbersCounts;
    }
}
