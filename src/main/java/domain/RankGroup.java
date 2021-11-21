package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankGroup {
    private final List<Rank> rankGroup;

    public RankGroup(LotteryTickets lottery, LastWeekLotteryNumber lastWeekLottery) {
        this.rankGroup = Collections.unmodifiableList(winningNumberList(lottery, lastWeekLottery));
    }

    private static List<Rank> winningNumberList(LotteryTickets lotteryTickets, LastWeekLotteryNumber lastWeekLottery) {
        List<Rank> numbers = new ArrayList<>();
        int loopNumber = lotteryTickets.size();
        for (int i = 0; i < loopNumber; i++) {
            numbers.add(getRank(lotteryTickets.lotteryTicket(i).matchCount(lastWeekLottery)));
        }

        return numbers;
    }

    public static Rank getRank(int winningNumberCount) {
        return new Rank(winningNumberCount);
    }

    public int value(int index) {
        return rankGroup.get(index).value();
    }

    public int count(int rank) {
        return (int) rankGroup.stream()
                .filter(number -> number.value() == rank)
                .count();
    }

    public int moneyPrizeRank(int rank) {
        return LotteryPrizeCalculation.winningAmount(rank, 1);
    }

}
