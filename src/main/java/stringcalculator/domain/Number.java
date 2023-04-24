package stringcalculator.domain;

public class Number {

  private static final String NUMBER_REGEX = "-?\\d+";

  private int number;

  public Number(final int number) {
    this.number = number;
  }

  public static Number convertNumber(String input) {
    if (!input.matches(NUMBER_REGEX)) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    return new Number(Integer.parseInt(input));
  }

  public int getNumber() {
    return number;
  }
}
