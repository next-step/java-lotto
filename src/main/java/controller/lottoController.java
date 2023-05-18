package controller;

import model.winning.BonusBall;
import model.lotto.Lottos;
import model.lotto.ManualLotto;
import model.winning.WinningNumbers;
import view.InputView;
import view.OutputView;

public class lottoController {

  public static void main(String[] args) {
    Lottos lottos = new Lottos();

    OutputView.purchasePrice();
    int purchaseAmount = InputView.getIntValue(); InputView.getStringValue(); // Scanner에 enter가 남아있어 enter를 먹어 없애기 위한 코드

    OutputView.manualPurchaseCount();
    int manualPurchaseAmount= InputView.getIntValue(); InputView.getStringValue(); // Scanner에 enter가 남아있어 enter를 먹어 없애기 위한 코드

    lottos.buyAutoLotto(purchaseAmount, manualPurchaseAmount);

    if (manualPurchaseAmount > 0) {
      OutputView.manualPurchaseLottoNumbers();
    }
    for (int i = 0; i < manualPurchaseAmount; i++) {
      lottos.addManualLotto(new ManualLotto(InputView.getStringValue()));
    }

    OutputView.lottos(lottos);

    OutputView.lastWeekWinningNumber();
    WinningNumbers winningNumbers = new WinningNumbers(InputView.getStringValue());

    OutputView.bonusBall();
    OutputView.statistics(lottos.findWinner(winningNumbers, new BonusBall(winningNumbers, InputView.getIntValue())));
  }
}
