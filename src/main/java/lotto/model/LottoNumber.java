package lotto.model;

import java.util.Objects;
import lotto.exception.LottoNegativeException;

public final class LottoNumber {

  private final int value;

  public LottoNumber(int value) {
    valid(value);
    this.value = value;
  }

  private void valid(int value) {
    if (value <= 0) {
      throw new LottoNegativeException();
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
    LottoNumber lottoNumber = (LottoNumber) o;
    return Objects.equals(value, lottoNumber.value);
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
