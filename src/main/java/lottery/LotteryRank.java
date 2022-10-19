package lottery;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static int getMatchingCount(LotteryRank lotteryRank) {
        return lotteryRank.matchingCount;
    }

    public static int getPrize(LotteryRank lotteryRank) {
        return lotteryRank.prize;
    }

    public static List<Integer> getUsedMatchingCounts() {
        return Arrays.stream(values())
                .map(LotteryRank::getMatchingCount)
                .collect(Collectors.toList());
    }

    public static int getPrizeOfMatchingCount(int matchingCount) {
        return getPrize(valueOf(matchingCount));
    }

    public static LotteryRank valueOf(int matchingCount) {
        return Arrays.stream(values())
                .filter(lotteryRank -> lotteryRank.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

}
