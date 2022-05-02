package lotto.model;

import java.util.Objects;
import lotto.exception.LottoNumberException;

public final class LottoNumber {

  private static final int MIN_VALUE = 1;
  private static final int MAX_VALUE = 45;
  private final int value;

  public LottoNumber(int value) {
    valid(value);
    this.value = value;
  }

  private void valid(int value) {
    if (value < MIN_VALUE || MAX_VALUE < value) {
      throw new LottoNumberException(value);
    }
  }

  public int currentNumber() {
    return this.value;
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

}
