package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
        FIRST(6, 2_000_000_000, "6개 일치 (2000000000원)"),
        SECOND(5, 1_500_000, "5개 일치 (1500000원)"),
        THIRD(4, 50_000, "4개 일치 (50000원)"),
        FOURTH(3, 5_000, "3개 일치 (5000원)"),
        MISS(0, 0, "3개 미만 일치 (0원)");

        private final int matchCount;
        private final long winningMoney;
        private final String description;

        Rank(int matchCount, int winningMoney, String description) {
                this.matchCount = matchCount;
                this.winningMoney = winningMoney;
                this.description = description;
        }

        public long winningMoney() {
                return winningMoney;
        }

        public String description() {
                return description;
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
