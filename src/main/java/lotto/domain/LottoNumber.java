package lotto.domain;

import java.util.Objects;

public class LottoNumber {

  private final int number;

  public LottoNumber(int number) {
    if (number < 1 || number > 45) {
      throw new IllegalArgumentException("로또번호가 1보다 작거나 45보다 클 수 없습니다.");
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
    return String.valueOf(number);
  }
}
