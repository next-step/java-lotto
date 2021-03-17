package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  private int value;
  private static final String INVALID_NUMBER = "유효하지 않은 로또 번호입니다.";
  private static final int MAX_VALUE = 45;
  private static final int MIN_VALUE = 1;

  public LottoNumber(int value) {
    validateNumber(value);
    this.value = value;
  }

  public static void validateNumber(int value) {
    if (value < MIN_VALUE || value > MAX_VALUE) {
      throw new IllegalArgumentException(INVALID_NUMBER);
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
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public int compareTo(LottoNumber target) {
    return this.value - target.value;
  }

  public int getNumber() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
