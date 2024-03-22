package factory;

import domain.Lottos;
import domain.Lotto;
import domain.LottoBall;
import domain.PositiveNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
  private final RandomFactory randomFactory;

  public LottoFactory(RandomFactory randomFactory) {
    this.randomFactory = randomFactory;
  }

  public Lotto randomLotto() {
    List<LottoBall> normalBalls = randomFactory.randomNumbers(Lotto.NORMAL_BALLS_COUNT)
            .stream()
            .map(LottoBall::new)
            .collect(Collectors.toList());

    return Lotto.of(LottoBall.of(randomFactory.randomNumber()), normalBalls);
  }

  public Lottos randomLottos(PositiveNumber size) {
    return new Lottos(IntStream.range(0, size.value())
            .mapToObj(i -> randomLotto())
            .collect(Collectors.toList()));
  }
}
