package stringcalculator;

public final class NonNegativeInteger {

  private static final int ZERO = 0;

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
}
