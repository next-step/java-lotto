package lotto.factory;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.PositiveNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
  private final RandomFactory randomFactory;

  public LottoFactory(RandomFactory randomFactory) {
    this.randomFactory = randomFactory;
  }

  public Lotto randomLotto() {
    List<PositiveNumber> duplicationList = new ArrayList<>();
    List<LottoBall> normalBalls = IntStream.range(0, Lotto.NORMAL_BALLS_COUNT)
            .mapToObj(i -> {
              PositiveNumber randomNumber = randomWithoutDuplication(duplicationList);
              duplicationList.add(randomNumber);
              return LottoBall.of(randomNumber);
            })
            .collect(Collectors.toList());

    return Lotto.of(LottoBall.of(randomWithoutDuplication(duplicationList)), normalBalls);
  }

  public Lottos randomLottos(PositiveNumber size) {
    return new Lottos(IntStream.range(0, size.value())
            .mapToObj(i -> randomLotto())
            .collect(Collectors.toList()));
  }

  private PositiveNumber randomWithoutDuplication(final List<PositiveNumber> duplicationList) {
    PositiveNumber number = randomFactory.randomNumber();
    while (duplicationList.contains(number)) {
      number = randomFactory.randomNumber();
    }

    return number;
  }
}
