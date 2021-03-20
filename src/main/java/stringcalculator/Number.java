package stringcalculator;

public final class Number {

  private final int number;

  public Number() {
    this(0);
  }
  public Number(String number) {
    this(Integer.parseInt(number));
  }

  public Number(int number) {
    if (number < 0) {
      throw new NegativeNumberException();
    }
    this.number = number;
  }

  public Number sum(Number other) {
    return new Number(this.number + other.number);
  }

  public int toInt() {
    return number;
  }
}
