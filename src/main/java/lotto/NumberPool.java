package lotto;

import static lotto.LottoGameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPool {

  private static final List<LottoNumber> randomBox = IntStream
      .rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
      .mapToObj(LottoNumber::get)
      .collect(Collectors.toList());

  private NumberPool() {
  }

  public static List<LottoNumber> generateNumberBundle(PublishStrategy publishStrategy) {
    return publishStrategy.publish();
  }

  public static List<LottoNumber> generateNumberBundle() {
    PublishStrategy strategy = () -> {
      Collections.shuffle(randomBox);

      return randomBox.stream()
          .limit(NUMBERS_PER_TICKET)
          .sorted()
          .collect(Collectors.toList());
    };

    return generateNumberBundle(strategy);
  }
}
