import domain.Lottos;
import domain.Lotto;
import domain.LottoBalls;
import domain.PositiveNumber;
import factory.LottoFactory;
import factory.RandomFactory;
import view.InputView;
import view.ResultView;

import java.util.Random;

public class Main {
  private static final LottoFactory lottoFactory = new LottoFactory(new RandomFactory(new Random()));

  public static void main(String[] args) {

    PositiveNumber count = Lotto.count(PositiveNumber.of((InputView.amountTotal())));
    ResultView.lotteryCount(count);

    Lottos lottos = lottoFactory.randomLottos(count);
    ResultView.lotteryList(lottos);

    LottoBalls winningBalls = InputView.winningBalls();
    ResultView.stats(lottos.results(winningBalls));
  }
}
