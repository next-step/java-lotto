package lotto.domain;

import java.util.Objects;

public class LottoNumber {
  public static final int MIN = 1;
  public static final int MAX = 45;
  private static final String EXCEPTION_MESSAGE = String.format("로또 번호는 %d~%d의 범위 안의 숫자여야만 한다.", MIN, MAX);

  private final int value;

  private LottoNumber(int value) {
    this.value = value;
  }

  public static LottoNumber generate(int value) {
    if (!isValidNumberRange(value)) {
      throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    return new LottoNumber(value);
  }

  private static boolean isValidNumberRange(int value) {
    return MIN <= value && value <= MAX;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber that = (LottoNumber) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
