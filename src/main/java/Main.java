import domain.Lotteries;
import domain.Lottery;
import domain.LotteryNumbers;
import domain.PositiveNumber;
import factory.LotteryFactory;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    PositiveNumber count = Lottery.count(PositiveNumber.of((InputView.amountTotal())));
    ResultView.lotteryCount(count);

    Lotteries lotteries = LotteryFactory.randomLotteries(count);
    ResultView.lotteryList(lotteries);

    LotteryNumbers winningNumbers = InputView.winningNumbers();
    ResultView.stats(lotteries.results(winningNumbers));
  }
}
