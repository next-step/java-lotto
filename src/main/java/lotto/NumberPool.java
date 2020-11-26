package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_BUNDLE;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class NumberPool {

  private static final List<LottoNumber> randomBox = IntStream
      .rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
      .mapToObj(LottoNumber::get)
      .collect(toList());

  private NumberPool() {
  }

  public static LottoNumberBundle generateNumberBundle(PublishStrategy publishStrategy) {
    return publishStrategy.publish();
  }

  public static LottoNumberBundle generateNumberBundle() {
    PublishStrategy strategy = () -> {
      Collections.shuffle(randomBox);

      return randomBox.stream()
          .limit(NUMBERS_PER_BUNDLE)
          .sorted()
          .collect(collectingAndThen(toList(), LottoNumberBundle::of));
    };
    return generateNumberBundle(strategy);
  }
}
