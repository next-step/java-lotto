package lotto.domain;

import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
  public static void main(String[] args) {
    LottoSet lottoSet = buyLotto();
    viewLottoResult(lottoSet);

    InputView.closeScanner();
  }

  private static LottoSet buyLotto() {
    int cost = InputView.inputCost();
    LottoPurchase lottoPurchase = new LottoPurchase(cost);

    int manualLottoCount = InputView.inputManualLottoCount();
    List<Lotto> manualLottos = InputView.inputManualLottoNumber(manualLottoCount);

    LottoSet lottoSet = LottoMachine.generateManualAndRandomLotto(lottoPurchase, manualLottos);
    ResultView.printLottoSet(lottoSet);

    return lottoSet;
  }

  private static void viewLottoResult(LottoSet lottoSet) {
    Lotto winningLotto = InputView.inputWinningLotto();
    LottoNumber bonusNumber = InputView.inputBonusNumber();
    WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, bonusNumber);
    LottoResult lottoResult = lottoSet.provideLottoResult(winningLottoWithBonus);
    ResultView.printLottoStatistics(lottoResult);
  }

}
