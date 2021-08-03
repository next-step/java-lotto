package lotto.domain;

import java.util.Comparator;
import java.util.Objects;

public class LottoNumber implements Comparator<LottoNumber> {

  private int number;

  public LottoNumber(int number) {
    this.number = number;
  }

  public LottoNumber() {
  }

  public int getNumber() {
    return number;
  }

  @Override
  public int compare(LottoNumber num1, LottoNumber num2) {
    return Integer.compare(num1.getNumber(), num2.getNumber());
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
    return getNumber() == that.getNumber();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNumber());
  }
}
