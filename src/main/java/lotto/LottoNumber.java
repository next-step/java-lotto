package lotto;

import java.util.Objects;

public class LottoNumber {
  private final int value;

  public LottoNumber(int number) {
    this.value = number;
  }

  public int getValue() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber that = (LottoNumber) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
