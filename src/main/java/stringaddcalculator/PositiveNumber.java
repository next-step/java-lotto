package stringaddcalculator;

public class PositiveNumber {

  private final int number;

  private PositiveNumber(Integer value) {
    this.number = value;
  }

  protected static PositiveNumber create(String value) {
    int number = Integer.parseInt(value);
    validatePositive(number);
    return new PositiveNumber(number);
  }

  protected static PositiveNumber createForNullOrEmpty() {
    int defaultNumber = 0;
    return new PositiveNumber(defaultNumber);
  }

  public int getNumber() {
    return number;
  }

  private static void validatePositive(int number) {
    if (number < 0) {
      throw new RuntimeException("the number is negative.");
    }
  }
}
