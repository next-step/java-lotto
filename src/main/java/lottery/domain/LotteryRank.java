package lottery.domain;

import java.util.Arrays;

public enum LotteryRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    public final int winningCount;

    public final int revenue;

    LotteryRank(int winningCount, int revenue) {
        this.winningCount = winningCount;
        this.revenue = revenue;
    }

    public static LotteryRank generate(int countWinningNumbers, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> {
                    if (countWinningNumbers == 5) {
                        if (matchBonus) {
                            return rank == SECOND;
                        }

                        return rank == THIRD;
                    }
                    return rank.winningCount == countWinningNumbers;
                })
                .findFirst()
                .orElse(NONE);
    }
}
