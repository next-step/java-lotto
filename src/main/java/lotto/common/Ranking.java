package lotto.common;

import java.util.stream.Stream;

public enum Ranking {

    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000);

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

    public static int getCompensationBy(int expect){
        return Stream.of(values())
                .filter(ranking -> ranking.expect == expect)
                .map(ranking -> ranking.compensation)
                .findAny()
                .orElseThrow(() -> new RuntimeException("2개 이하로는 금액을 보상받을 수 없습니다."));
    }
}
