package lotto;

import lotto.model.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoRunner {

  public static void main(String[] args) {

    int paid = LottoInputView.askPurchaseAmount();

    LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());

    Lottos lottos = lottoGenerator.generate(paid);

    LottoOutputView.printCountOf(lottos);
    LottoOutputView.print(lottos);

    List<Integer> winningNumbers = LottoInputView.askWinningNumbers();
    List<Integer> countOfMatchingNumbers = lottos.getCountOfMatchingNumbers(winningNumbers);

//    winningNumbersCounts.forEach(Prize::win);

    LottoOutputView.printWinnings();
  }
}
