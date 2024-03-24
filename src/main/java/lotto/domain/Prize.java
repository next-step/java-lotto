package lotto.domain;

import java.util.Arrays;

public enum Match {
    THREE_AGREEMENT(3) {
        @Override
        public int solvePrize() {
            return PrizeConstant.FOURTH_PLACE;
        }
    },
    FOUR_AGREEMENT(4) {
        @Override
        public int solvePrize() {
            return SaveMatch.matchResult.get(PrizeConstant.THIRD_PLACE) + 1;
        }
    },
    FIVE_AGREEMENT(5) {
        @Override
        public int solvePrize() {
            return SaveMatch.matchResult.get(PrizeConstant.SECOND_PLACE) + 1;
        }
    },
    SIX_AGREEMENT(6) {
        @Override
        public int solvePrize() {
            return SaveMatch.matchResult.get(PrizeConstant.FIRST_PLACE) + 1;
        }
    },
    ;

    private int matchCount;

    Prize(int matchCount) {
        checkMatchCount(matchCount);
        this.matchCount = matchCount;
    }

    public abstract int solvePrize();

    public static Match checkMatchCount(int matchCount) {
        return Arrays.stream(values()).filter(match -> match.matchCount < 3).findFirst().orElseThrow(() -> new IllegalArgumentException("적어도 3개 이상 일치해야 합니다."));
    }
}
