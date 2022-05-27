package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private final int matchCount;
    private final int money;

    Ranking(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Ranking findMatchRanking(int matchCount, boolean matchBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.isEqualRanking(matchCount, matchBonus))
                .findAny()
                .orElse(MISS);
    }

    private boolean isEqualRanking(int matchCount, boolean matchBonus) {
        if (this == SECOND && matchCount == SECOND.matchCount && !matchBonus) {
            return false;
        }
        return this.matchCount == matchCount;
    }

    public int price(int count) {
        return this.money * count;
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return matchCount +"개 일치, 보너스 볼 일치 (" + money + ")원";
        }
        return matchCount +"개 일치 (" + money + ")원";
    }
}
