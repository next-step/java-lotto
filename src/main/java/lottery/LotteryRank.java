package lottery;

import java.util.Arrays;
import java.util.List;

public enum LotteryRank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int matchingCount;
    private final int prize;

    LotteryRank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public static List<LotteryRank> getLotteryRanks() {
        return List.of(values());
    }

    public static LotteryRank valueOf(int matchingCount) {
        return Arrays.stream(values())
                .filter(lotteryRank -> lotteryRank.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

}
