package lotto.domain;

import java.util.Objects;

public class LottoNumber {

  private static final String OVER_NUMBER_RANGE = "로또 숫자의 범위를 초과했습니다.";

  private static final int LOTTO_MIN_NUM = 1;
  private static final int LOTTO_MAX_NUM = 45;

  private final int number;

  public LottoNumber(int number) {
    if (!isValidRange(number)) {
      throw new IllegalArgumentException(OVER_NUMBER_RANGE);
    }
    this.number = number;
  }

  private boolean isValidRange(int number) {
    return number >= LOTTO_MIN_NUM && number <= LOTTO_MAX_NUM;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
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
    return Objects.hash(number);
  }
}
