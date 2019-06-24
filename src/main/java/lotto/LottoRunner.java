package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Prize;
import lotto.model.RandomNumberGenerator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoRunner {

  public static void main(String[] args) {

    int paid = LottoInputView.askPurchaseAmount();

    LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());

    List<Lotto> lottos = lottoGenerator.generate(paid);
    int amount = lottos.size();

    LottoOutputView.print(amount);
    LottoOutputView.print(lottos);

    List<Integer> winningNumbers = LottoInputView.askWinningNumbers();
    List<Integer> winningNumbersCounts = lottos.stream().mapToInt(lotto -> lotto.hasHowMany(winningNumbers)).boxed().collect(toList());

//    winningNumbersCounts.forEach(Prize::win);

    LottoOutputView.printWinnings();
  }
}
