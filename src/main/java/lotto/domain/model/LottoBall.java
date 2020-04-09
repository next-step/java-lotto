package lotto.domain.model;

import java.util.Objects;

public class LottoBall {

  public static final int UPPER_BOUND = 45;
  public static final int LOWER_BOUND = 1;

  private int number;

  public LottoBall(int integer) {
    throwIfInvalid(integer);

    number = integer;
  }

  @Override
  public String toString() {
    return Integer.toString(number);
  }

  private void throwIfInvalid(int integer) {
    if (integer < LOWER_BOUND || integer > UPPER_BOUND) {
      throw new IllegalArgumentException("로또 번호는 1 과 45 사이여야 합니다.");
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

    if (!(o instanceof LottoBall))
      return false;

    LottoBall other = (LottoBall) o;

    return this.number == other.number;
  }
}
