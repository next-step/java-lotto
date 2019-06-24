package lotto;

import lotto.model.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoRunner {

  public static void main(String[] args) {

    int paid = LottoInputView.askPurchaseAmount();

    LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());

    Lottos lottos = lottoGenerator.generate(paid);

    LottoOutputView.printCountOf(lottos);
    LottoOutputView.printPickedNumbersOf(lottos);

    List<Integer> winningNumbers = LottoInputView.askWinningNumbers();
    Analyzer analyzer = new Analyzer(winningNumbers);
    analyzer.analyze(lottos);

    LottoOutputView.print(analyzer);


    //LottoOutputView.printWinnings();
  }
}
