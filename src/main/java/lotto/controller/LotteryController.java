package lotto.controller;

import java.util.List;
import lotto.domain.LotteryNumber;
import lotto.domain.LotteryNumbers;
import lotto.domain.LotteryStatistic;
import lotto.domain.LotteryTickets;
import lotto.domain.Money;
import lotto.domain.WinningLotteryNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LotteryController {
  private static final LotteryController INSTANCE = new LotteryController();

  private final InputView inputView;
  private final ResultView resultView;

  private LotteryController() {
    inputView = new InputView();
    resultView = new ResultView();
  }

  public static LotteryController getInstance() {
    return INSTANCE;
  }

  public void play() {
    LotteryTickets tickets = buyTickets();
    resultView.printLotteryTickets(tickets);

    WinningLotteryNumbers winningNumbers = inputWinningNumbers();

    LotteryStatistic statistic = produceStatistic(tickets, winningNumbers);
    resultView.printStatistic(statistic);
  }

  private LotteryTickets buyTickets() {
    long money = inputView.inputBuyAmount();

    return LotteryTickets.buy(new Money(money));
  }

  private WinningLotteryNumbers inputWinningNumbers() {
    List<Integer> winningNumbers = inputView.inputWinningNumbers();
    int bonusNumber = inputView.inputBonusNumber();

    return new WinningLotteryNumbers(winningNumbers, bonusNumber);
  }

  private LotteryStatistic produceStatistic(LotteryTickets tickets, WinningLotteryNumbers winningNumbers) {
    LotteryStatistic lotteryStatistic = new LotteryStatistic();
    lotteryStatistic.produceTickets(tickets, winningNumbers);
    return lotteryStatistic;
  }

}
