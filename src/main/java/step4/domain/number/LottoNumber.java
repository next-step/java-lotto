package step4.domain.number;

import step4.exception.InvalidLottoNumberException;
import step4.exception.InvalidSplitStringException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
  private static final String UNDER_LOTTO_MIN_LIMIT = "로또의 최소 번호는 1입니다.";
  private static final String OVER_LOTTO_MAX_LIMIT = "로또의 최대 번호는 45입니다.";
  private static final int LOTTO_MIN = 1;
  private static final int LOTTO_MAX = 45;
  private static final int ZERO = 0;
  private static final String SPLIT_ERROR_MESSAGE = "분해할 수 없는 문자열입니다. 문자열: ";

  private final int number;

  public LottoNumber(int number) {
    if (number < LOTTO_MIN) {
      throw new InvalidLottoNumberException(UNDER_LOTTO_MIN_LIMIT + number);
    }

    if (number > LOTTO_MAX) {
      throw new InvalidLottoNumberException(OVER_LOTTO_MAX_LIMIT + number);
    }
    this.number = number;
  }

  @Override
  public int compareTo(LottoNumber targetLottoNumber) {
    return Integer.compare(this.number, targetLottoNumber.number);
  }

  public String toString() {
    return String.valueOf(number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber lottoNumber1 = (LottoNumber) o;
    return number == lottoNumber1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  public static LottoNumber splitOneToken(String token) {
    int number = ZERO;
    try {
      number = Integer.parseInt(token);
    } catch (NumberFormatException numberFormatException) {
      throw new InvalidSplitStringException(SPLIT_ERROR_MESSAGE + token);
    }
    return new LottoNumber(number);
  }
}