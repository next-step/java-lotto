package lotto;

import java.util.Arrays;
import java.util.Comparator;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    FAIL(0, 0);

    private final Integer matchingCount;
    private final Integer rewardPrice;

    Rank(Integer matchingCount, Integer rewardPrice) {
        this.matchingCount = matchingCount;
        this.rewardPrice = rewardPrice;
    }

    public static Rank[] winningRanks() {
        return Arrays.stream(Rank.values())
                .filter(Rank::isFail)
                .sorted(Comparator.comparingInt(Rank::matchingCount))
                .toArray(Rank[]::new);
    }

    public static Rank convertRanking(int count) {
        return Arrays.stream(Rank.values())
                .filter(it -> it.matchingCount.equals(count))
                .findFirst()
                .orElse(FAIL);
    }

    public Integer matchingCount() {
        return matchingCount;
    }

    public boolean isFail() {
        return matchingCount > 0;
    }

    public Integer rewardPrice() {
        return rewardPrice;
    }
}
