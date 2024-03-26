package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNo {

  public static final int LOTTO_MIN_NUMBER = 1;
  public static final int LOTTO_MAX_NUMBER = 45;
  private static final Map<Integer, LottoNo> LOTTO_NUMBERS = new HashMap<>();
  public static final String INVALID_LOTTO_NUMBER_INPUT = "해당 숫자는 로또 번호 범위가 아닙니다. 번호를 다시 확인해주세요. input: %s";

  private final int number;

  static {
    for (int number = LOTTO_MIN_NUMBER; number <= LOTTO_MAX_NUMBER; number++) {
      LOTTO_NUMBERS.put(number, new LottoNo(number));
    }
  }

  private LottoNo(int number) {
    this.number = number;
  }

  public static LottoNo of(int number) {
    checkNumbersRange(number);
    return LOTTO_NUMBERS.get(number);
  }

  public int getNo() {
    return number;
  }

  private static void checkNumbersRange(int number) {
    if (LOTTO_MIN_NUMBER > number || number > LOTTO_MAX_NUMBER) {
      throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_INPUT, number));
    }
  }
}
