package lotto.domain;

import java.util.Objects;

public class LottoNo {

  public static final int UPPER_BOUND = 45;
  public static final int LOWER_BOUND = 1;

  private int number;

  public LottoNo(int integer) {
    throwIfInvalid(integer);

    number = integer;
  }

  private void throwIfInvalid(int integer) {
    if (integer < LOWER_BOUND || integer > UPPER_BOUND) {
      throw new IllegalArgumentException("LottoNo should be between 1 and 45.");
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;

    if (!(o instanceof LottoNo))
      return false;

    LottoNo other = (LottoNo) o;

    return this.number == other.number;
  }
}
