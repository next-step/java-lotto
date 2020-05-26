package lottery.domain;

import java.util.Map;

public class StatisticsBoard {

    private final Map<Integer, Integer> winnerTicketsMap;

    public StatisticsBoard(Map<Integer, Integer> winnerTicketsMap) {
        this.winnerTicketsMap = winnerTicketsMap;
    }

    public int findTicketCountsByLotteryRank(LotteryRanks lotteryRank) {
        return winnerTicketsMap.get(lotteryRank.getRequiredNumberCounts());
    }
}
