package lotto3.controller;


import lotto3.domain.LottoNumber;
import lotto3.domain.LottoResults;
import lotto3.domain.LottoTickets;
import lotto3.domain.Money;
import lotto3.domain.WinningNumbers;
import lotto3.util.LottoFactory;
import lotto3.view.InputView;
import lotto3.view.OutputView;

public class LottoController {

  public static void main(String[] args) {
    Money investMoney = InputView.scanMoney();
    LottoTickets tickets = LottoFactory.createLottoTickets(investMoney);

    OutputView.printLottoTickets(tickets);

    WinningNumbers winningNumbers = InputView.scanWinningNumbers();
    LottoNumber bonusNumber = InputView.scanBonusNumber();
    winningNumbers.validateHasDuplicateNumber(bonusNumber);

    LottoResults results = tickets.calculateLotteryResults(winningNumbers, bonusNumber);

    OutputView.printLottoResults(results);
    OutputView.printProfitRate(results.calculateProfitRate(investMoney));
  }

}
