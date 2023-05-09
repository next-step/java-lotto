package lotto3.controller;


import lotto3.domain.LottoNumber;
import lotto3.domain.LottoNumbers;
import lotto3.domain.LottoResults;
import lotto3.domain.LottoTickets;
import lotto3.domain.ManualLottoCount;
import lotto3.domain.Money;
import lotto3.util.LottoFactory;
import lotto3.view.InputView;
import lotto3.view.OutputView;

public class LottoController {

  public static void main(String[] args) {
    Money investMoney = InputView.scanMoney();
    ManualLottoCount lottoCount = InputView.scanManualCount();

    LottoTickets manualLottoTickets = InputView.scanManualLottoNumbers(lottoCount);

    Money leftMoney = investMoney.decreaseMoney(lottoCount);
    LottoTickets autoTickets = LottoFactory.createLottoTickets(leftMoney);

    OutputView.printLottoTickets(autoTickets, manualLottoTickets);

    LottoTickets totalLottoTickets = LottoTickets.merge(manualLottoTickets, autoTickets);

    LottoNumbers winningNumbers = InputView.scanWinningNumbers();
    LottoNumber bonusNumber = InputView.scanBonusNumber();
    winningNumbers.validateHasDuplicateNumber(bonusNumber);

    LottoResults results = totalLottoTickets.calculateLotteryResults(winningNumbers, bonusNumber);

    OutputView.printLottoResults(results);
    OutputView.printProfitRate(results.calculateProfitRate(investMoney));
  }

}
