package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int LOTTO_MINIMUM_NUMBER = 1;
  public static final int LOTTO_MAXIMUM_NUMBER = 45;
  private static final String ILLEGAL_LOTTO_NUMBER_MESSAGE = "올바른 로또 번호를 입력해주세요. 입력된 번호 : ";
  private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

  static {
    for (int i = LOTTO_MINIMUM_NUMBER; i <= LOTTO_MAXIMUM_NUMBER; i++) {
      lottoNumbers.put(i, new LottoNumber(i));
    }
  }

  private final int number;

  private LottoNumber(int number) {
    this.number = number;
  }

  public static LottoNumber of(int number) {
    validateLottoNumber(number);

    return lottoNumbers.get(number);
  }

  private static void validateLottoNumber(int number) {
    if (!isLottoNumber(number)) {
      throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_MESSAGE + number);
    }
  }

  private static boolean isLottoNumber(int number) {
    return number >= LOTTO_MINIMUM_NUMBER && number <= LOTTO_MAXIMUM_NUMBER;
  }

  public int number() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LottoNumber that = (LottoNumber) o;

    return number == that.number;
  }

  @Override
  public int hashCode() {
    return number;
  }

  @Override
  public int compareTo(LottoNumber otherLottoNumber) {
    return Integer.compare(number, otherLottoNumber.number);
  }
}
