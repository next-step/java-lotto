package lottery;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LotteryRank {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

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

    public static boolean isUsedMatchingCount(int matchingCount) {
        return Arrays.stream(values())
                .anyMatch(lotteryRank -> lotteryRank.matchingCount == matchingCount);
    }

    public static int getPrizeOfMatchingCount(int matchingCount) {
        return getPrize(valueOf(matchingCount));
    }

    public static LotteryRank valueOf(int matchingCount) {
        return Arrays.stream(values())
                .filter(lotteryRank -> lotteryRank.matchingCount == matchingCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 등수입니다."));
    }

}
