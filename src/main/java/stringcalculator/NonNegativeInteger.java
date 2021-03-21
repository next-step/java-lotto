package stringcalculator;

import java.util.Objects;

public final class NonNegativeInteger {

  public static final int ZERO = 0;

  private final int number;

  public NonNegativeInteger() {
    this(ZERO);
  }
  public NonNegativeInteger(String number) {
    this(Integer.parseInt(number));
  }

  public NonNegativeInteger(int number) {
    if (number < ZERO) {
      throw new NegativeNumberException();
    }
    this.number = number;
  }

  public NonNegativeInteger sum(NonNegativeInteger other) {
    return new NonNegativeInteger(this.number + other.number);
  }

  public int toInt() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonNegativeInteger)) {
      return false;
    }
    NonNegativeInteger that = (NonNegativeInteger) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
