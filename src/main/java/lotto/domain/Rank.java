package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
        FIRST(6, 2_000_000_000),
        SECOND(5, 1_500_000),
        THIRD(4, 50_000),
        FOURTH(3, 5_000),
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

        public boolean isSameMatchCount(int code) {
                return matchCount == code;
        }

        public static Rank valueOfRank(int matchCount) {
                return Stream.of(Rank.values())
                    .filter(val -> val.isSameMatchCount(matchCount))
                    .findAny()
                    .orElse(MISS);
        }
}
