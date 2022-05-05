package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int matchCount;
    private final int money;

    Ranking(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Ranking findMatchRanking(int matchCount) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.isEqualRanking(matchCount))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("당첨자가 아닙니다."));
    }

    public int getPriceByCount(int count) {
        return money * count;
    }

    private boolean isEqualRanking(int matchCount) {
        return this.matchCount == matchCount;
    }

    @Override
    public String toString() {
        return matchCount +"개 일치 (" + money + ")원";
    }
}
