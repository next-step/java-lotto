package lotto;

import lotto.model.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoRunner {

  public static void main(String[] args) {

    int paid = LottoInputView.askPurchaseAmount();

    LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());
    Lottos lottos = lottoGenerator.generate(paid);

    LottoOutputView.printCountOf(lottos);
    LottoOutputView.printPickedNumbersOf(lottos);

    Lotto winningLotto = LottoInputView.askWinningNumbers();

    Analyzer analyzer = new Analyzer(winningLotto);
    Report report = analyzer.analyze(lottos);

    LottoOutputView.print(report);
  }
}
