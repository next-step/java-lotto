package lotto.domain;

import java.util.stream.Stream;

public enum Ranking {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private static final int MIN_EXPECT = 1;

    private static final int MAX_EXPECT = 6;

    private static final int UNPAID = 0;

    private final int expect;

    private final int compensation;

    Ranking(int expect, int compensation) {
        this.expect = expect;
        this.compensation = compensation;
    }

    public int getExpect() {
        return expect;
    }

    public int getCompensation() {
        return compensation;
    }

    public static int getCompensationBy(int expect) {
        validateExpect(expect);
        return getCompensationIfExpectMatchOverThree(expect);
    }

    private static Integer getCompensationIfExpectMatchOverThree(int expect) {
        return Stream.of(values())
                .filter(ranking -> ranking.expect == expect)
                .map(ranking -> ranking.compensation)
                .findAny()
                .orElse(UNPAID);
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
