package lotto;

import lotto.utils.Const;
import lotto.view.InputVIew;
import lotto.view.ResultView;
import lotto.vo.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryMain {
    public static void main(String[] args) {
        InputVIew inputVIew = new InputVIew();

        Money money = new Money(inputVIew.purchaseAmount());
        ResultView resultView = new ResultView();
        resultView.printPurchaseTicketCount(money);
        LotteryGame game = new LotteryGame(money);
        resultView.printLottoNumber(game.getLottoNumber());

        LotteryNumber inputLottery = new LotteryNumber(getLottery(inputVIew.winningNumber()));
//        Map<Rank, Integer> ranks = game.getWinningStatistics(new WinningNumber(inputLottery));

//        resultView.winningNumberStatistics(ranks);
//        resultView.revenueRate(game.getRevenue());
    }

    public static Set<Integer> getLottery(String winningLottoNumber) {
        return Arrays.asList(splitComma(winningLottoNumber))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
    }

    public static String[] splitComma(String winningLottoNumber) {
        return winningLottoNumber.split(Const.FORMAT_COMMA);
    }
}
