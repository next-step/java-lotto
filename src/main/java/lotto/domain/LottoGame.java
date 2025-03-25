package lotto.domain;

import lotto.domain.result.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
  public static void main(String[] args) {
    int cost = InputView.inputCost();
    LottoPurchase lottoPurchase = new LottoPurchase(cost);
    LottoSet lottoSet = LottoMachine.generateRandomLotto(lottoPurchase);
    ResultView.printLottoSet(lottoSet);

    Lotto winningLotto = InputView.inputWinningLotto();
    LottoResult lottoResult = lottoSet.calculateResult(winningLotto);
    ResultView.printLottoStatistics(lottoResult);

    InputView.closeScanner();
  }

}
