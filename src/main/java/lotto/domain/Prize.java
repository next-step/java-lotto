package lotto.domain;

import lotto.constant.Constant;

import java.util.Arrays;

public enum Prize {
    THREE_AGREEMENT(3) {
        @Override
        public int solvePrize() {
            return Constant.FOURTH_PLACE;
        }
    },
    FOUR_AGREEMENT(4) {
        @Override
        public int solvePrize() {
            return Constant.THIRD_PLACE;
        }
    },
    FIVE_AGREEMENT(5) {
        @Override
        public int solvePrize() {
            return Constant.SECOND_PLACE;
        }
    },
    SIX_AGREEMENT(6) {
        @Override
        public int solvePrize() {
            return Constant.FIRST_PLACE;
        }
    },
    ;

    private final int matchCount;

    Prize(int matchCount) {
        this.matchCount = matchCount;
    }

    public abstract int solvePrize();

    public static Prize checkMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(match -> match.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("적어도 3개 이상 일치해야 합니다."));
    }
}
