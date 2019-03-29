package lottery.domain;

import java.util.Arrays;

public enum LotteryRank {

    FIRST(6, 2_000_000_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.matchCount == winningCount;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.matchCount == winningCount && matchBonus;
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.matchCount == winningCount && !matchBonus;
        }
    },
    FOURTH(4, 50_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.matchCount == winningCount;
        }
    },
    FIFTH(3, 5_000) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return this.matchCount == winningCount;
        }
    },
    NONE(0, 0) {
        @Override
        protected boolean match(int winningCount, boolean matchBonus) {
            return winningCount < FIFTH.matchCount;
        }
    };

    protected final int matchCount;

    protected final Money winningMoney;

    LotteryRank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = Money.valueOf(winningMoney);
    }

    public static LotteryRank generate(int countWinningNumbers, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.match(countWinningNumbers, matchBonus))
                .findFirst()
                .orElse(NONE);
    }

    protected abstract boolean match(int winningCount, boolean matchBonus);

    public Money getWinningMoney(TicketCount count) {
        return this.winningMoney.times(Money.valueOf(count.getAmount()));
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}
