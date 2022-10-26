package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    MISS(0, 0, (matchCount, hasBonus) -> matchCount < 3) {
        @Override
        public long calcWinningMoneyPerRank(int winningCount) {
            return 0;
        }
    },
    FIFTH(3, 5_000, (matchCount, hasBonus) -> matchCount == 3) {
        @Override
        public long calcWinningMoneyPerRank(int winningCount) {
            return 5_000L * winningCount;
        }
    },
    FOURTH(4, 50_000, (matchCount, hasBonus) -> matchCount == 4) {
        @Override
        public long calcWinningMoneyPerRank(int winningCount) {
            return 50_000L * winningCount;
        }
    },
    THIRD(5, 1_500_000, (matchCount, hasBonus) -> matchCount == 5 && !hasBonus) {
        @Override
        public long calcWinningMoneyPerRank(int winningCount) {
            return 1_500_000L * winningCount;
        }
    },
    SECOND(5, 30_000_000, (matchCount, hasBonus) -> matchCount == 5 && hasBonus) {
        @Override
        public long calcWinningMoneyPerRank(int winningCount) {
            return 30_000_000L * winningCount;
        }
    },
    FIRST(6, 2_000_000_000, (matchCount, hasBonus) -> matchCount == 6) {
        @Override
        public long calcWinningMoneyPerRank(int winningCount) {
            return 2_000_000_000L * winningCount;
        }
    };

    private final int countOfMatch;
    private final int winningMoney;
    private final BiPredicate<Integer, Boolean> rankChecker;
    public abstract long calcWinningMoneyPerRank(int winningCount);

    LottoRank(int countOfMatch, int winningMoney, BiPredicate<Integer, Boolean> rankChecker) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.rankChecker = rankChecker;
    }

    public static LottoRank win(int countOfMatch, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.rankChecker.test(countOfMatch, hasBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
