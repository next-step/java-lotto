package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

  public static final int LOTTO_NUMBER_COUNT_INBOUND = 0;
  public static final int LOTTO_NUMBER_COUNT_OUTBOUND = 6;
  private static final int LOTTO_NUMBER_INBOUND = 1;
  private static final int LOTTO_NUMBER_OUTBOUND = 45;

  private static final List<LottoNumber> numbers = new ArrayList<>();

  static {
    for (int number = LOTTO_NUMBER_INBOUND; number <= LOTTO_NUMBER_OUTBOUND; number++) {
      numbers.add(new LottoNumber(number));
    }
  }

  public synchronized static List<LottoNumber> pick(int number) {
    Collections.shuffle(numbers);

    return numbers.subList(LOTTO_NUMBER_COUNT_INBOUND, number);
  }
}
