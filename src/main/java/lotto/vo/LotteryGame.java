package lotto.vo;

import java.util.ArrayList;
import java.util.List;

public class LotteryGame {
    List<Lottery> lotteries;

    public LotteryGame(int tickets) {
        lotteries = new ArrayList<>();
        createTicket(tickets);
    }

    private void createTicket(int tickets) {
        for (int i = 0; i < tickets; i++) {
            lotteries.add(new LotteryGenerator().lotteryNumbers2());
        }
    }

    public void getWinningStatistics(WinningNumber winningNumber) {
        for (int i = 0; i < lotteries.size(); i++) {
            Rank rank = winningNumber.match(lotteries.get(i));
        }
    }
}
