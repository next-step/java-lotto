package lottery;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LotteryRanks {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int rank;
    private final int prize;

    LotteryRanks(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public static int getRanks(LotteryRanks lotteryRanks) {
        return lotteryRanks.rank;
    }

    public static int getPrize(LotteryRanks lotteryRanks) {
        return lotteryRanks.prize;
    }

    public static List<Integer> getRanksInUse() {
        return Arrays.stream(LotteryRanks.values())
                .map(LotteryRanks::getRanks)
                .collect(Collectors.toList());
    }

    public static int getPrizeOfRank(int rank) {
        return Arrays.stream(LotteryRanks.values())
                .filter(lotteryRanks -> lotteryRanks.rank == rank)
                .findFirst()
                .map(LotteryRanks::getPrize)
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 등수입니다."));
    }

}
