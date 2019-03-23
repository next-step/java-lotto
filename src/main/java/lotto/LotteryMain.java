package lotto;

import lotto.view.InputVIew;
import lotto.view.ResultView;

public class LotteryMain {
    public static void main(String[] args) {
        InputVIew inputVIew = new InputVIew();
        inputVIew.printPurchaseAmount();

        ResultView resultView = new ResultView();
        resultView.printPurchaseTicketCount(14);

        inputVIew.printWinningNumber();

        resultView.winningNumberStatistics();
        resultView.revenueRate(0.24);
    }
}
