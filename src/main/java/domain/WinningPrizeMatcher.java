package domain;

import java.util.HashMap;
import java.util.Map;

public enum WinningPrizeMatcher {
    ZERO(0, false) {
        @Override
        public WinningPrizes calculateWinningPrize() {
            return WinningPrizes.MISS;
        }
    },
    ONE(1, false) {
        @Override
        public WinningPrizes calculateWinningPrize() {
            return WinningPrizes.MISS;
        }
    },
    TWO(2, false){
        @Override
        public WinningPrizes calculateWinningPrize() {
            return WinningPrizes.MISS;
        }
    },
    THREE(3, false){
        @Override
        public WinningPrizes calculateWinningPrize() {
            return WinningPrizes.FIFTH_PRIZE;
        }
    },
    FOUR(4, false){
        @Override
        public WinningPrizes calculateWinningPrize() {
            return WinningPrizes.FOURTH_PRIZE;
        }
    },
    FIVE(5, false){
        @Override
        public WinningPrizes calculateWinningPrize() {
            return WinningPrizes.THIRD_PRIZE;
        }
    },
    FIVE_BONUS(5, true){
        @Override
        public WinningPrizes calculateWinningPrize() {
            return WinningPrizes.SECOND_PRIZE;
        }
    },
    SIX(6, false) {
        @Override
        public WinningPrizes calculateWinningPrize() {
            return WinningPrizes.FIRST_PRIZE;
        }
    };

    private static final int HASH_GENERATION_NUMBER = 31;
    public static final int THRESHOLD = -1;
    private static final Map<Integer, WinningPrizeMatcher> WINNING_PRIZE_MATCHERS_MAP = new HashMap<>();

    private int numberOfCount;
    private boolean isBonusMatch;

    WinningPrizeMatcher(int numberOfCount, boolean isBonusMatch) {
        this.numberOfCount = numberOfCount;
        this.isBonusMatch = isBonusMatch;
    }

    static {
        for (WinningPrizeMatcher value : WinningPrizeMatcher.values()) {
            WINNING_PRIZE_MATCHERS_MAP.put(getHashCode(value.numberOfCount, value.isBonusMatch), value);
        }
    }

    public static int getHashCode(int numberOfCount, boolean isBonusMatch) {
        int bonusNum = 0;
        if (isBonusMatch) {
            bonusNum = 1;
        }
        return numberOfCount * HASH_GENERATION_NUMBER + bonusNum;
    }

    public static WinningPrizeMatcher valueOf(int numberOfCount, boolean isBonusMatch) {
        isBonusMatch = checkBonus(numberOfCount, isBonusMatch);
        return WINNING_PRIZE_MATCHERS_MAP.get(getHashCode(numberOfCount, isBonusMatch));
    }

    private static boolean checkBonus(int numberOfCount, boolean isBonusMatch) {
        if (FIVE_BONUS.getNumberOfCount() != numberOfCount && isBonusMatch) {
            isBonusMatch = false;
        }
        return isBonusMatch;
    }

    public int getNumberOfCount() {
        if (this == ZERO || this == ONE || this == TWO) {
            return THRESHOLD;
        }
        return numberOfCount;
    }

    public abstract WinningPrizes calculateWinningPrize();
}
