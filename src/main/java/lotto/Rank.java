package lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    FAIL(0, 0);

    private final Integer matchingCount;
    private final Integer rewardPrice;

    Rank(Integer matchingCount, Integer rewardPrice) {
        this.matchingCount = matchingCount;
        this.rewardPrice = rewardPrice;
    }

    public static Rank[] winningRanks() {
        return Arrays.stream(Rank.values())
                .filter(Rank::isMatch)
                .toArray(Rank[]::new);
    }

    public static Rank convertRanking(int count, boolean matchBonus) {
        if (isSecond(count)) {
            return matchSecondRank(matchBonus);
        }
        return Arrays.stream(Rank.values())
                .filter(it -> it.matchingCount.equals(count))
                .findFirst()
                .orElse(FAIL);
    }

    private static Rank matchSecondRank(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    private static boolean isSecond(int count) {
        return count == 5;
    }

    public Integer matchingCount() {
        return matchingCount;
    }

    private boolean isMatch() {
        return matchingCount > 0;
    }

    public Integer rewardPrice() {
        return rewardPrice;
    }
}
