package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankGroup {
    private static final int WINNING_NUMBER_MIN = 3;
    private static final int WINNING_NUMBER_ZERO = 0;
    private final List<Rank> rankGroup;

    public RankGroup(LotteryTickets lottery, LastWeekLotteryNumber lastWeekLottery) {
        this.rankGroup = Collections.unmodifiableList(lotteryRank(lottery, lastWeekLottery));
    }

    private static List<Rank> lotteryRank(LotteryTickets lottery, LastWeekLotteryNumber lastWeekLottery) {
        List<Rank> numbers = new ArrayList<>();
        int loopNumber = lottery.size();
        for (int i = 0; i < loopNumber; i++) {
            numbers.add(getRank(lottery.lotteryTicket(i).matchCount(lastWeekLottery)));
        }

        return numbers;
    }

    private static Rank getRank(int winningNumberCount) {
        return new Rank(RankCalculation.ranking(checkRankMin(winningNumberCount)));
    }

    public static int checkRankMin(int count) {
        if (count < WINNING_NUMBER_MIN) {
            return WINNING_NUMBER_ZERO;
        }
        return count;
    }

    public int value(int index) {
        return rankGroup.get(index).value();
    }

    public int count(int rank) {
        return (int) rankGroup.stream()
                .filter(number -> number.value() == rank)
                .count();
    }

    public int moneyPrizeRank(int rank){
        return LotteryPrizeCalculation.winningAmount(rank, 1);
    }

}
