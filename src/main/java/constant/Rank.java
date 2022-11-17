package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2000000000L),
    SECOND(5, 1500000L),
    SECOND_WITH_BONUS(7, 30000000L),
    THIRD(4, 50000L),
    FOURTH(3, 5000L),
    UNKNOWN(0, 0L);

    private final int countOfMatchedNumber;
    private final long reward;

    Rank(int countOfMatchedNumber, long reward) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        this.reward = reward;
    }

    public static Rank findRank(int countOfMatchedNumber) {
        return Arrays.stream(Rank.values()).filter(rank -> rank.countOfMatchedNumber == countOfMatchedNumber).collect(Collectors.toList()).get(0);
    }

    public long findReward() {
        return reward;
    }
}
