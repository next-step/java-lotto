package lotto;

import lotto.view.InputVIew;
import lotto.view.ResultView;
import lotto.vo.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryMain {
    public static void main(String[] args) {
        InputVIew inputVIew = new InputVIew();
        int tickets = new Money(inputVIew.purchaseAmount()).getLotto();

        ResultView resultView = new ResultView();
        resultView.printPurchaseTicketCount(tickets);
        LotteryGame game = new LotteryGame(tickets);

        Lottery inputLottery = Lottery.toLotteries(getLottery(inputVIew.winningNumber()));
        Map<Rank, Integer> ranks = game.getWinningStatistics(new WinningNumber(inputLottery));

        resultView.winningNumberStatistics(ranks);
        resultView.revenueRate(game.getRevenue());
    }

    public static List<Integer> getLottery(String winningLottoNumber) {
        return Arrays.asList(splitComma(winningLottoNumber))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static String[] splitComma(String winningLottoNumber) {
        return winningLottoNumber.split(LotteryGenerator.FORMAT_COMMA);
    }
}
