package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;

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

  public static List<LottoNumber> generateNumberBundle(PublishStrategy publishStrategy) {
    return publishStrategy.publish();
  }

  public static List<LottoNumber> generateNumberBundle() {
    PublishStrategy strategy = new PublishStrategy() {
      @Override
      public List<LottoNumber> publish() {
        Collections.shuffle(randomBox);

        return randomBox.stream()
            .limit(NUMBERS_PER_TICKET)
            .sorted()
            .collect(toList());
      }

      @Override
      public LottoNumberBundle publish1() {
        return null;
      }
    };
    return generateNumberBundle(strategy);
  }

  public static LottoNumberBundle generateNumberBundle1(PublishStrategy publishStrategy) {
    return publishStrategy.publish1();
  }


  public static LottoNumberBundle generateNumberBundle1() {
    PublishStrategy strategy = new PublishStrategy() {
      @Override
      public List<LottoNumber> publish() {
        return null;
      }

      @Override
      public LottoNumberBundle publish1() {
        Collections.shuffle(randomBox);

        return randomBox.stream()
            .limit(NUMBERS_PER_TICKET)
            .sorted()
            .collect(collectingAndThen(toList(), LottoNumberBundle::of));
      }
    };
    return generateNumberBundle1(strategy);
  }
}
