package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {

  private int value;

  public LottoNumber(int value) {
    validate(value);
    this.value = value;
  }

  private void validate(int value) {
    if (value < 1 || value > 45) {
      throw new IllegalArgumentException("로또 넘버는 1이상 45이하의 수입니다");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }
}