package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
  public static void main(String[] args) {
    int cost = InputView.inputCost();
    LottoPurchase lottoPurchase = new LottoPurchase(cost);
    LottoSet lottoSet = LottoMachine.generateRandomLotto(lottoPurchase);
    ResultView.printLottoSet(lottoSet);

    Lotto winningLotto = InputView.inputWinningLotto();
    LottoNumber bonusNumber = InputView.inputBonusNumber();
    WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, bonusNumber);
    LottoResult lottoResult = lottoSet.provideLottoResult(winningLottoWithBonus);
    ResultView.printLottoStatistics(lottoResult);

    InputView.closeScanner();
  }

}
