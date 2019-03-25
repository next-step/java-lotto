package lotto;

import lotto.view.ResultView;
import lotto.vo.*;

import java.util.Arrays;
import java.util.Map;

public class LotteryMain {
    public static void main(String[] args) {

        int tickets = new Money(1000).getLotto();// inputVIew.printPurchaseAmount();

        ResultView resultView = new ResultView();
        resultView.printPurchaseTicketCount(tickets);
        LotteryGame game = new LotteryGame(tickets);

        Map<Rank, Integer> ranks = game.getWinningStatistics(new WinningNumber(Lottery.toLotteries(Arrays.asList(1, 2, 3, 4, 5, 6))));//inputVIew.printWinningNumber();

        resultView.winningNumberStatistics(ranks);
        resultView.revenueRate(new Money(5000).yield(new Money(10000)));
    }
}
