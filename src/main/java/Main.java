import lotto.domain.*;
import lotto.factory.LottoFactory;
import lotto.factory.RandomFactory;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Random;

public class Main {
  private static final LottoFactory lottoFactory = new LottoFactory(new RandomFactory(new Random()));

  public static void main(String[] args) {

    PositiveNumber count = Lotto.count(PositiveNumber.of((InputView.amountTotal())));
    ResultView.lotteryCount(count);

    Lottos lottos = lottoFactory.randomLottos(count);
    ResultView.lotteryList(lottos);
    ResultView.stats(lottos.results(InputView.lottery()));
  }
}
