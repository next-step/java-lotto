package lotto.domain;

public enum Ranking {

    FIFTH(3, 5_000) ,
    FOURTH(4, 50000),
    THIRD(5, 1_500_000) {
        @Override
        public boolean isEqualTo(int matchCount, boolean hasBonusNumber) {
            return matchCount == getExpect() && !hasBonusNumber;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        public boolean isEqualTo(int matchCount, boolean hasBonusNumber) {
            return matchCount == getExpect() && hasBonusNumber;
        }
    },
    FIRST(6, 2_000_000_000);

    private static final int MIN_EXPECT = 1;

    private static final int MAX_EXPECT = 6;

    private final int expect;

    private final int compensation;

    Ranking(int expect, int compensation) {
        validateExpect(expect);
        this.expect = expect;
        this.compensation = compensation;
    }

    public boolean isEqualTo(int matchCount, boolean hasBonusNumber) {
        return matchCount == getExpect();
    }

    public int getExpect() {
        return expect;
    }

    public int getCompensation() {
        return compensation;
    }

    private static void validateExpect(int expect) {
        if (isOutOfRange(expect)) {
            throw new IllegalArgumentException("예상 입력값이 잘못되었습니다.");
        }
    }

    private static boolean isOutOfRange(int expect) {
        return !(expect >= MIN_EXPECT && expect <= MAX_EXPECT);
    }
}
