package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
  private final int value;

  public LottoNumber(int number) {
    this.value = number;
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

  public int getNumber() {
    return value;
  }

  @Override
  public int compareTo(LottoNumber other) {
    return Integer.compare(this.value, other.value);
  }
}
