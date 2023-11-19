package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
        FIRST(6, false, 2_000_000_000),
        SECOND(5, true, 30_000_000),
        THIRD(5, false, 1_500_000),
        FOURTH(4, false, 50_000),
        FIFTH(3, false, 5_000),
        MISS(0, false, 0);

        private final int matchCount;
        private final boolean matchedBonus;
        private final long winningMoney;

        Rank(int matchCount, boolean matchedBonus, int winningMoney) {
                this.matchCount = matchCount;
                this.matchedBonus = matchedBonus;
                this.winningMoney = winningMoney;
        }

        public int matchCount() {
                return matchCount;
        }

        public long winningMoney() {
                return winningMoney;
        }

        public boolean isSameMatchCount(int matchCount, boolean matchedBonus) {
                return this.matchCount == matchCount && this.matchedBonus == matchedBonus;
        }

        public static Rank valueOfRank(int matchCount, boolean matchedBonus) {
                return Stream.of(Rank.values())
                    .filter(val -> val.isSameMatchCount(matchCount, matchedBonus))
                    .findAny()
                    .orElse(MISS);
        }
}
