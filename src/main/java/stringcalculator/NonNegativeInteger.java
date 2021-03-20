package stringcalculator;

public final class NonNegativeInteger {

  private final int number;

  public NonNegativeInteger() {
    this(0);
  }
  public NonNegativeInteger(String number) {
    this(Integer.parseInt(number));
  }

  public NonNegativeInteger(int number) {
    if (number < 0) {
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
