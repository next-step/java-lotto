package lotto.model;

import lotto.exception.LottoNumberException;

import java.util.Objects;

public final class LottoNumber {

  static final int MIN_VALUE = 1;
  static final int MAX_VALUE = 45;

  private final int value;

  public LottoNumber(int value) {
    validate(value);
    this.value = value;
  }

  private void validate(int value) {
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
