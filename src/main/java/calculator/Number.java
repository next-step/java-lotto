package calculator;

public class Number {

  private static final String NUMBER_REGEX = "[0-9]+";
  private static final int ZERO = 0;

  private int value;

  public Number(int value) {
    validNaturalNumber(value);
    this.value = value;
  }

  public static Number from(String value) {
    validNumber(value);
    return new Number(Integer.parseInt(value));
  }

  private static void validNumber(String text) {
    if (!text.matches(NUMBER_REGEX)) {
      throw new RuntimeException();
    }
  }

  private void validNaturalNumber(int value) {
    if (value < ZERO) {
      throw new RuntimeException();
    }
  }

  public int getValue() {
    return value;
  }

  public Number sum(Number number2) {
    return new Number(this.value + number2.getValue());
  }

}
