package lotto3.controller;

import java.util.List;
import java.util.Map;
import lotto3.domain.LottoResults;
import lotto3.domain.LottoTickets;
import lotto3.domain.Prize;
import lotto3.util.LottoFactory;
import lotto3.view.InputView;
import lotto3.view.OutputView;

public class LottoController {

  public static void main(String[] args) {
    int investMoney = InputView.scanMoney();
    LottoTickets tickets = LottoFactory.createLottoTickets(investMoney);

    OutputView.printLottoTickets(tickets);

    List<Integer> winningNumbers = InputView.scanWinningNumbers();

    LottoResults results = tickets.calculateLotteryResults(winningNumbers);

    OutputView.printLottoResults(results);
    OutputView.printProfitRate(results.calculateProfitRate(investMoney));
  }

}
