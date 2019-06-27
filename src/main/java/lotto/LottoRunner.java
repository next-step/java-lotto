package lotto;

import lotto.model.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoRunner {

  public static void main(String[] args) {

    Money paidMoney = LottoInputView.askPurchaseAmount();

    LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());
    Lottos lottos = lottoGenerator.generate(paidMoney);

    LottoOutputView.printCountOf(lottos);
    LottoOutputView.printPickedNumbersOf(lottos);

    Lotto lottoWithWinningNumbers = LottoInputView.askWinningNumbers();
    int bonusNumber = LottoInputView.askBonusNumber();
    WinningLotto winningLotto = new WinningLotto(lottoWithWinningNumbers, bonusNumber);

    Analyzer analyzer = new Analyzer(winningLotto);
    Report report = analyzer.analyze(lottos);

    LottoOutputView.print(report);
  }
}
