package lottery.domain;

import java.util.Map;

public class LotteryGame {

    private LotteryGame() {
    }

    public static LotteryGame getInstance() {
        return new LotteryGame();
    }

    public LotteryGameResult drawWinnerLotteryTickets(LotteryTicketsGroup lotteryTicketsGroup,
                                                      LotteryTicket lastWinnerTicket,
                                                      LotteryNumber bonusBallNumber) {
        Map<LotteryRank, Integer> gameResultBoard = lotteryTicketsGroup
                .findWinnerTicketCountsByRank(lastWinnerTicket, bonusBallNumber);
        return LotteryGameResult.from(gameResultBoard);
    }
}
