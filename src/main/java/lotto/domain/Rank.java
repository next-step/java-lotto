package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
        FIRST(6, 2_000_000_000),
        SECOND(5, 30_000_000),
        THIRD(5, 1_500_000),
        FOURTH(4, 50_000),
        FIFTH(3, 5_000),
        MISS(0, 0);

        private final int matchCount;
        private final long winningMoney;

        Rank(int matchCount, int winningMoney) {
                this.matchCount = matchCount;
                this.winningMoney = winningMoney;
        }

        public int matchCount() {
                return matchCount;
        }

        public long winningMoney() {
                return winningMoney;
        }

        public static Rank valueOfRank(int matchCount, boolean matchedBonus) {
                if (matchCount <= FIFTH.matchCount && matchedBonus) {
                        return MISS;
                }
                return Stream.of(Rank.values())
                    .filter(val -> val.isSameMatchCount(matchCount, matchedBonus))
                    .findAny()
                    .orElse(MISS);
        }

        private boolean isSameMatchCount(int matchCount, boolean matchedBonus) {
                if (matchCount != 5) {
                        return this.matchCount == matchCount;
                }
                if (this.matchCount == matchCount && matchedBonus) {
                        return this == SECOND;
                }
                return this == THIRD;
        }
}
