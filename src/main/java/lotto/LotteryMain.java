package lotto;

import lotto.view.ResultView;
import lotto.vo.Lottery;
import lotto.vo.LotteryGame;
import lotto.vo.Money;
import lotto.vo.WinningNumber;

import java.util.Arrays;

public class LotteryMain {
    public static void main(String[] args) {

        int tickets = new Money(1000).getLotto();// inputVIew.printPurchaseAmount();

        ResultView resultView = new ResultView();
        resultView.printPurchaseTicketCount(tickets);
        LotteryGame game = new LotteryGame(tickets);

        game.getWinningStatistics(new WinningNumber(Lottery.toLotteries(Arrays.asList(1, 2, 3, 4, 5, 6))));//inputVIew.printWinningNumber();

        resultView.winningNumberStatistics();
        resultView.revenueRate(0.24);
    }
}
