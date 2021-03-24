package lotto.domain;

import java.util.Objects;

public class LottoNumber {

  public static final int START_NUMBER = 1;
  public static final int END_NUMBER = 45;
  private int number;

  public LottoNumber(int number) {
    if (number < START_NUMBER || number > END_NUMBER) {
      throw new IllegalArgumentException("out of bound.");
    }
    this.number = number;
  }

  public int getNumber() {
    return number;
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
}
