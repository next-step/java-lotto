package lotto.domain;

import java.util.Objects;

public class LottoNumber {

  private int number;

  public LottoNumber(int number) {
    if (number < 1 || number > 45) {
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
