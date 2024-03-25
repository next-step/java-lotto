package lotto.factory;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.PositiveNumber;

import java.util.ArrayList;
import java.util.Arrays;
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
    List<LottoBall> lottoBalls = IntStream.range(0, Lotto.LOTTO_BALLS_COUNT)
            .mapToObj(i -> {
              PositiveNumber randomNumber = randomWithoutDuplication(duplicationList);
              duplicationList.add(randomNumber);
              return LottoBall.of(randomNumber);
            })
            .collect(Collectors.toList());

    return Lotto.of(lottoBalls);
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

  public Lottos manualLottos(List<String[]> lottoNumbersList) {
    return new Lottos(lottoNumbersList.stream()
            .map(lottoNumbers -> Lotto.of(numbersToLottoBall(lottoNumbers)))
            .collect(Collectors.toList()));
  }

  private List<LottoBall> numbersToLottoBall(String[] lottoNumbers) {
    return Arrays.stream(lottoNumbers)
            .map(number -> LottoBall.of(PositiveNumber.of(number)))
            .collect(Collectors.toList());
  }
}
