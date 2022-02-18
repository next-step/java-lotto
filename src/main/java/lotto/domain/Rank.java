package lotto.domain;

import java.util.Arrays;


public enum Rank {
    NONE(0, 0) {
        @Override
        boolean match(int matchCount, boolean matchBonus) {
            return matchCount < 3;
        }
    },
    FIFTH(3, 5000) {
        @Override
        boolean match(int matchCount, boolean matchBonus) {
            return matchCount == getMatchCount();
        }
    },
    FOURTH(4, 50000) {
        @Override
        boolean match(int matchCount, boolean matchBonus) {
            return matchCount == getMatchCount();
        }
    },
    THIRD(5, 1500000) {
        @Override
        boolean match(int matchCount, boolean matchBonus) {
            return matchCount == getMatchCount() && !matchBonus;
        }
    },
    SECOND(5, 30000000) {
        @Override
        boolean match(int matchCount, boolean matchBonus) {
            return matchCount == getMatchCount() && matchBonus;
        }
    },
    FIRST(6, 2000000000) {
        @Override
        boolean match(int matchCount, boolean matchBonus) {
            return matchCount == getMatchCount();
        }
    };

    private final int matchCount;
    private final long prizeMoney;

    Rank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }

    abstract boolean match(int matchCount, boolean matchBonus);

    public static Rank find(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(targetRank -> targetRank.match(matchCount, matchBonus))
                .findFirst().orElse(NONE);
    }
}
