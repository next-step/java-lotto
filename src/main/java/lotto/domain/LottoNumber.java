package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;

  private static final Map<Integer, LottoNumber> cachedLottoNumbers = new HashMap<>(MAX_LOTTO_NUMBER);

  static {
    for (int number = MIN_LOTTO_NUMBER; number < MAX_LOTTO_NUMBER; number++) {
      cachedLottoNumbers.put(number, new LottoNumber(number));
    }
  }
  private final int number;

  private LottoNumber(String number) {
    this(Integer.parseInt(number.trim()));
  }

  private LottoNumber(int number) {
    validateLottoNumber(number);
    this.number = number;
  }

  public static LottoNumber from(String number) {
    return from(Integer.parseInt(number.trim()));
  }
  public static LottoNumber from(int number) {
    validateLottoNumber(number);
    return cachedLottoNumbers.get(number);
  }

  private static void validateLottoNumber(int number) {
    if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("로또번호가 1보다 작거나 45보다 클 수 없습니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
