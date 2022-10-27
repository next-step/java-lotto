package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    MISS(0, (matchCount, hasBonus) -> matchCount < 3) {
        @Override
        public long winningMoneyPerRank() {
            return 0;
        }
    },
    FIFTH(3, (matchCount, hasBonus) -> matchCount == 3) {
        @Override
        public long winningMoneyPerRank() {
            return 5_000L;
        }
    },
    FOURTH(4, (matchCount, hasBonus) -> matchCount == 4) {
        @Override
        public long winningMoneyPerRank() {
            return 50_000L;
        }
    },
    THIRD(5, (matchCount, hasBonus) -> matchCount == 5 && !hasBonus) {
        @Override
        public long winningMoneyPerRank() {
            return 1_500_000L;
        }
    },
    SECOND(5, (matchCount, hasBonus) -> matchCount == 5 && hasBonus) {
        @Override
        public long winningMoneyPerRank() {
            return 30_000_000L;
        }
    },
    FIRST(6, (matchCount, hasBonus) -> matchCount == 6) {
        @Override
        public long winningMoneyPerRank() {
            return 2_000_000_000L;
        }
    };

    private final int countOfMatch;
    private final BiPredicate<Integer, Boolean> rankChecker;

    public abstract long winningMoneyPerRank();

    LottoRank(int countOfMatch, BiPredicate<Integer, Boolean> rankChecker) {
        this.countOfMatch = countOfMatch;
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
}
