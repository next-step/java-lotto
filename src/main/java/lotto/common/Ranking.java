package lotto.common;

import java.util.stream.Stream;

public enum Ranking {

    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000);

    private final int matchCount;
    private final int compensation;

    public static int getCompensationBy(int matchCount){
        return Stream.of(values())
                .filter(ranking -> ranking.matchCount == matchCount)
                .map(ranking -> ranking.compensation)
                .findAny()
                .orElseThrow(() -> new RuntimeException("2개 이하로는 금액을 보상받을 수 없습니다."));
    }

    Ranking(int matchCount, int compensation) {
        this.matchCount = matchCount;
        this.compensation = compensation;
    }
}
