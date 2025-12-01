package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;

  private static final String ERROR_OUT_OF_RANGE = "로또 번호는 1~45 범위의 숫자여야 한다";

  private final int number;

  public LottoNumber(int number) {
    validateRange(number);
    this.number = number;
  }

  public int number() {
    return number;
  }

  private static void validateRange(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
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
    return Objects.hashCode(number);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }


  @Override
  public int compareTo(LottoNumber o) {
    return Integer.compare(this.number, o.number);
  }
}
