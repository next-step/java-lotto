package lotto;

import lotto.view.InputVIew;
import lotto.view.ResultView;
import lotto.vo.*;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryMain {
    public static void main(String[] args) {
        InputVIew inputVIew = new InputVIew();
        int tickets = new Money(inputVIew.purchaseAmount()).getLotto();

        ResultView resultView = new ResultView();
        resultView.printPurchaseTicketCount(tickets);
        LotteryGame game = new LotteryGame(tickets);

        Lottery inputLottery = Lottery.toLotteries(Arrays.asList(inputVIew.winningNumber().split(LotteryGenerator.FORMAT_COMMA)).stream().map(Integer::valueOf).collect(Collectors.toList()));
        Map<Rank, Integer> ranks = game.getWinningStatistics(new WinningNumber(inputLottery));

        resultView.winningNumberStatistics(ranks);
        resultView.revenueRate(game.getRevenue());
    }
}
