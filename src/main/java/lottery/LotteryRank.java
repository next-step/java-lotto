package lottery;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LotteryRank {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int rank;
    private final int prize;

    LotteryRank(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public static int getRank(LotteryRank lotteryRank) {
        return lotteryRank.rank;
    }

    public static int getPrize(LotteryRank lotteryRank) {
        return lotteryRank.prize;
    }

    public static List<Integer> getUsedRanks() {
        return Arrays.stream(values())
                .map(LotteryRank::getRank)
                .collect(Collectors.toList());
    }

    public static boolean isUsedRank(int rank) {
        return Arrays.stream(values())
                .anyMatch(lotteryRank -> lotteryRank.rank == rank);
    }

    public static int getPrizeOfRank(int rank) {
        return getPrize(valueOf(rank));
    }

    public static LotteryRank valueOf(int rank) {
        return Arrays.stream(values())
                .filter(lotteryRank -> lotteryRank.rank == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 등수입니다."));
    }

}
