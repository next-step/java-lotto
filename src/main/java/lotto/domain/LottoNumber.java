package lotto.domain;

import java.util.Objects;

public class LottoNumber {

  public final static int MINIMUM = 1;
  public final static int MAXIMUM = 45;

  private final int number;

  public LottoNumber(int number) {

    if (number < MINIMUM || number > MAXIMUM) {
      throw new IllegalArgumentException();
    }

    this.number = number;
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
    return number + "";
  }
}
