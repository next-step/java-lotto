package lotto.controller;

import java.util.List;
import lotto.domain.LotteryNumbers;
import lotto.domain.LotteryStatistic;
import lotto.domain.LotteryTickets;
import lotto.domain.Money;
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

    LotteryNumbers lotteryNumbers = inputWinningNumbers();

    LotteryStatistic statistic = produceStatistic(tickets, lotteryNumbers);
    resultView.printStatistic(statistic);
  }

  private LotteryTickets buyTickets() {
    long money = inputView.inputBuyAmount();

    return LotteryTickets.buy(new Money(money));
  }

  private LotteryNumbers inputWinningNumbers() {
    List<Integer> winningNumbers = inputView.inputWinningNumbers();
    return new LotteryNumbers(winningNumbers);
  }

  private LotteryStatistic produceStatistic(LotteryTickets tickets, LotteryNumbers lotteryNumbers) {
    LotteryStatistic lotteryStatistic = new LotteryStatistic();
    lotteryStatistic.produceTickets(tickets, lotteryNumbers);
    return lotteryStatistic;
  }

}
