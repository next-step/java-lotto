package lotto;

import lotto.utils.Const;
import lotto.view.InputVIew;
import lotto.view.ResultView;
import lotto.vo.LotteryGame;
import lotto.vo.LotteryNumber;
import lotto.vo.Money;
import lotto.vo.Ranks;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryMain {
    public static void main(String[] args) {
        InputVIew inputVIew = new InputVIew();
        ResultView resultView = new ResultView();
        Money money = new Money(inputVIew.purchaseAmount());
        LotteryGame game = new LotteryGame(money);

        resultView.printPurchaseTicketCount(money);
        resultView.printLottoNumber(game.getLottoNumber());

        LotteryNumber inputLottery = new LotteryNumber(getLottery(inputVIew.winningNumber()), inputVIew.bonusBall());

        Ranks ranks = game.getWinningStatistics(inputLottery);
        resultView.winningNumberStatistics(ranks);

        double profit = money.getProfit(ranks);
        resultView.revenueRate(profit);
    }

    public static Set<Integer> getLottery(String winningLottoNumber) {
        return Arrays.stream(splitComma(winningLottoNumber))
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
    }

    public static String[] splitComma(String winningLottoNumber) {
        return winningLottoNumber.split(Const.FORMAT_COMMA);
    }
}
