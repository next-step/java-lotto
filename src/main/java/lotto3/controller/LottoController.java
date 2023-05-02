package lotto3.controller;

import java.util.List;
import java.util.Map;
import lotto3.domain.LottoTicket;
import lotto3.domain.Prize;
import lotto3.util.LottoFactory;
import lotto3.util.LottoResultCalculator;
import lotto3.view.InputView;
import lotto3.view.OutputView;

public class LottoController {

  public static void main(String[] args) {
    int investMoney = InputView.scanMoney();
    List<LottoTicket> tickets = LottoFactory.createLottoTickets(investMoney);

    OutputView.printLottoTickets(tickets);

    List<Integer> winningNumbers = InputView.scanWinningNumbers();
    Map<Prize, Long> lottoResults = LottoResultCalculator.calculate(tickets, winningNumbers);

    OutputView.printLottoResults(lottoResults);
    OutputView.printProfitRate(lottoResults, investMoney);
  }

}
