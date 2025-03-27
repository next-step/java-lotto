package model.lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000) {
        @Override
        public boolean matches(int matchCount, int bonusMatchCount) {
            return getMatchCount() == matchCount;
        }
    },
    SECOND(5, 30_000_000){
        @Override
        public boolean matches(int matchCount, int bonusMatchCount) {
            return getMatchCount() == matchCount && bonusMatchCount == 1;
        }
    },
    THIRD(5, 1_500_000){
        @Override
        public boolean matches(int matchCount, int bonusMatchCount) {
            return getMatchCount() == matchCount && bonusMatchCount == 0;
        }
    },
    FOURTH(4, 50_000){
        @Override
        public boolean matches(int matchCount, int bonusMatchCount) {
            return getMatchCount() == matchCount;
        }
    },
    FIFTH(3, 5_000){
        @Override
        public boolean matches(int matchCount, int bonusMatchCount) {
            return getMatchCount() == matchCount;
        }
    },
    ZERO(0, 0){
        @Override
        public boolean matches(int matchCount, int bonusMatchCount) {
            return false;
        }
    };
    private final int matchCount;
    private final int winningPrice;

    Rank(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static Rank of(int matchCount, int bonusMatchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches(matchCount, bonusMatchCount))
                .findFirst()
                .orElse(ZERO);
    }

    public int getWinningPrice(){
        return this.winningPrice;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public abstract boolean matches(int matchCount, int bonusMatchCount);
}
