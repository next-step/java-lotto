package lotto.model;

import java.util.Objects;

public class LottoNumber {

  public static final int LOTTO_NUMBER_RANGE_START = 1;
  public static final int LOTTO_NUMBER_RANGE_END = 45;
  private static final String LOTTO_NUMBER_OUT_OT_RANGE_ERROR_MSG = "입력된 로또 번호는 %d으로 로또 번호는 1~45 범위 안에 있어야합니다.";

  private final int value;

  public LottoNumber(int value) {
    validateLottoNumber(value);
    this.value = value;
  }

  public static LottoNumber create(int value) {
    return new LottoNumber(value);
  }

  public int getValue() {
    return this.value;
  }

  private void validateLottoNumber(int value) {
    if (value < LOTTO_NUMBER_RANGE_START || value > LOTTO_NUMBER_RANGE_END) {
      throw new IllegalArgumentException(String.format(LOTTO_NUMBER_OUT_OT_RANGE_ERROR_MSG, value));
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
  public String toString() {
    return String.valueOf(this.value);
  }
}
