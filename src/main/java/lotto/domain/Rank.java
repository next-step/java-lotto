package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, false, 0) {
        @Override
        protected boolean matchRank(int countOfMatch, boolean containsBonus) {
            return countOfMatch < 3 && countOfMatch >= 0;
        }
    },
    FIFTH(3, false, 5000) {
        @Override
        protected boolean matchRank(int countOfMatch, boolean containsBonus) {
            return countOfMatch == 3;
        }
    },
    FOURTH(4, false, 50000) {
        @Override
        protected boolean matchRank(int countOfMatch, boolean containsBonus) {
            return countOfMatch == 4;
        }
    },
    THIRD(5, false, 1500000) {
        @Override
        protected boolean matchRank(int countOfMatch, boolean containsBonus) {
            return countOfMatch == 5 && !containsBonus;
        }
    },
    SECOND(5, true, 30000000) {
        @Override
        protected boolean matchRank(int countOfMatch, boolean containsBonus) {
            return countOfMatch == 5 && containsBonus;
        }
    },
    FIRST(6, false, 2000000000) {
        @Override
        protected boolean matchRank(int countOfMatch, boolean containsBonus) {
            return countOfMatch == 6;
        }
    };

    public static final String FIND_RANK_EXCEPTION = "일치하는 숫자와 보너스 숫자 여부로 등수를 찾을 수 없습니다.";

    private final int countOfMatch;
    private final boolean containsBonus;
    private final long prizeMoney;

    Rank(int countOfMatch, boolean containsBonus, long prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.containsBonus = containsBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valeOf(int countOfMatch, boolean containsBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchRank(countOfMatch, containsBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(FIND_RANK_EXCEPTION));
    }

    public long calculateTotalPrizePerRank(long rankCnt) {
        return this.prizeMoney * rankCnt;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    protected abstract boolean matchRank(int countOfMatch, boolean containsBonus);

    public boolean isSecond() {
        return this == SECOND;
    }
}
