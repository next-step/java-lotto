package lottery.domain;

import java.util.Arrays;

public enum LotteryRank {
    FIRST(6, 2_000_000_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.winningCount == winningCount;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.winningCount == winningCount && matchBonus;
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.winningCount == winningCount && !matchBonus;
        }
    },
    FOURTH(4, 50_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.winningCount == winningCount;
        }
    },
    FIFTH(3, 5_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.winningCount == winningCount;
        }
    },
    NONE(0, 0) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return winningCount < FIFTH.winningCount;
        }
    };

    public final int winningCount;

    public final int revenue;

    LotteryRank(int winningCount, int revenue) {
        this.winningCount = winningCount;
        this.revenue = revenue;
    }

    protected abstract boolean match(int winningCount, boolean matchBonus);

    public static LotteryRank generate(int countWinningNumbers, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.match(countWinningNumbers, matchBonus))
                .findFirst()
                .orElse(NONE);
    }
}
