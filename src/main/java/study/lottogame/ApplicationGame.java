package study.lottogame;

import java.util.List;
import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.LottoNumber;
import study.lottogame.domain.Money;
import study.lottogame.factory.LotteriesFactory;
import study.lottogame.factory.LotteryFactory;
import study.lottogame.ui.InputView;
import study.lottogame.ui.OutputView;

public class ApplicationGame {

  public static void main(String[] args) {
    Money money = InputView.inputPurchaseMoney();
    Lotteries lotteries = LotteriesFactory.create(money);
    OutputView.printLotteries(lotteries);

    List<LottoNumber> winningNumbers = InputView.inputWinningNumbers();
    Lottery winningLottery = LotteryFactory.create(winningNumbers);
    OutputView.printResult(money, lotteries.getWinningCountsByRank(winningLottery));
  }
}
