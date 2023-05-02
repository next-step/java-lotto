package lotto2.controller;

import java.util.List;
import java.util.Map;
import lotto2.domain.LottoTicket;
import lotto2.domain.Prize;
import lotto2.util.LottoFactory;
import lotto2.util.LottoResultCalculator;
import lotto2.view.InputView;
import lotto2.view.OutputView;

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
