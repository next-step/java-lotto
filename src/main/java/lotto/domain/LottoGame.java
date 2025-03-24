package lotto.domain;

import lotto.domain.generate.RandomLottoGenerator;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResultAnalyzer;
import lotto.domain.result.LottoResultAnalyzerImpl;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
  public static void main(String[] args) {
    int cost = InputView.inputCost();
    LottoSet lottoSet = new LottoSet(cost, new RandomLottoGenerator());
    ResultView.printLottoSet(lottoSet);

    Lotto winningLotto = InputView.inputWinningLotto();
    LottoResultAnalyzer analyzer = new LottoResultAnalyzerImpl();
    LottoResult lottoResult = analyzer.analyze(lottoSet, winningLotto);
    ResultView.printLottoStatistics(lottoResult);

    InputView.closeScanner();
  }

}
