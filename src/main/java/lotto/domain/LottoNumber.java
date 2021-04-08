package lotto.domain;

import java.util.Objects;

import static lotto.constants.BaseConstants.LOTTO_NUMBER_GREATER_THAN_OR_EQUALS;
import static lotto.constants.BaseConstants.LOTTO_NUMBER_LESS_THAN_OR_EQUALS;

public class LottoNumber {
  private static final String EXCEPTION_MESSAGE = "로또 번호는 1~45의 범위 안의 숫자여야만 한다.";

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
    return LOTTO_NUMBER_GREATER_THAN_OR_EQUALS <= value && value <= LOTTO_NUMBER_LESS_THAN_OR_EQUALS;
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
