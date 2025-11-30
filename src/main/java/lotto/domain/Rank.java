package lotto.domain;

public enum Rank implements Matchable {
    FIRST(6, 2000000_000) {
        @Override
        public boolean isMatch(int match) {
            return match == 6;
        }
    },
    THIRD(5, 1500000) {
        @Override
        public boolean isMatch(int match) {
            return match == 5;
        }
    },
    FOURTH(4, 50000) {
        @Override
        public boolean isMatch(int match) {
            return match == 4;
        }
    },
    FIFTH(3, 5000) {
        @Override
        public boolean isMatch(int match) {
            return match == 3;
        }
    };

    private final int match;
    private final int prize;

    Rank(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public int prize() {
        return prize;
    }

    public int match() {
        return match;
    }

    public static Rank from(int matchCount) {
        for (Rank rank : values()) {
            if (rank.isMatch(matchCount)) {
                return rank;
            }
        }
        return null;
    }
}
