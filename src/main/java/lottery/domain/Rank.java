package lottery.domain;

import java.util.Arrays;

public enum Rank {

    FAIL(0, 0),
    FOUR(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2000_000_000);

    private final Integer matchCount;
    private final Integer profit;

    Rank(Integer matchCount, Integer profit) {
        this.matchCount = matchCount;
        this.profit = profit;
    }

    public static Rank valueOf(Integer matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount.equals(matchCount))
                .findFirst()
                .orElse(FAIL);
    }

    public Integer profit() {
        return profit;
    }

    public Integer matchCount() {
        return matchCount;
    }
}
