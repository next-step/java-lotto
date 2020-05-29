package lottery.domain;

import java.util.Map;

public class LotteryGame {

    private LotteryGame() {
    }

    public static LotteryGame getInstance() {
        return new LotteryGame();
    }

    public Map<LotteryRank, Integer> drawLottery(LotteryTicketsGroup lotteryTicketsGroup,
                                                 LotteryTicket lastWinnerTicket) {
        return lotteryTicketsGroup.findWinnerTicketCountsByRank(lastWinnerTicket);
    }
}
