package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
  public static void main(String[] args) {
    int cost = InputView.inputCost();
    LottoSet lottoSet = new LottoSet(cost, new RandomLottoGenerator());
    ResultView.printLottoSet(lottoSet);
    Lotto winningLotto = InputView.inputWinningLotto();
    LottoResult lottoResult = LottoResultAnalyzer.analyze(lottoSet, winningLotto);
    ResultView.printLottoStatistics(lottoResult);
    InputView.closeScanner();
  }

}
