package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

  private static final int LOTTO_NUMBERS_SIZE = 6;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;

  private static final List<LottoNumber> allLottoNumbers = new ArrayList<>(MAX_LOTTO_NUMBER);

  static {
    for (int number = MIN_LOTTO_NUMBER; number < MAX_LOTTO_NUMBER; number++) {
      allLottoNumbers.add(new LottoNumber(number));
    }
  }

  public static List<LottoNumber> create() {
    Collections.shuffle(allLottoNumbers);
    return allLottoNumbers.subList(0, LOTTO_NUMBERS_SIZE);
  }

}
