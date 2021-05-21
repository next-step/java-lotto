package stringadder.domain;

import java.util.Objects;

public class Number {

  public static final Number ZERO_NUMBER = new Number(0);

  private static final String NEGATIVE_NOT_ALLOWED = "숫자는 양수로 입력해주세요.";

  private static final String PLEASE_INPUT_POSITIVE_INT = "더할 숫자는 자연수로 입력해주세요.";

  private final int inputNumber;

  Number(int inputNumber) {
    this.inputNumber = inputNumber;
  }

  public static Number fromString(String input) {
    int inputNumber = parseInt(input);
    validatePositiveNumber(inputNumber);
    return new Number(inputNumber);
  }

  public static Number sum(Number one, Number theOther) {
    return new Number(one.inputNumber + theOther.inputNumber);
  }

  private static int parseInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      throw new IllegalArgumentException(PLEASE_INPUT_POSITIVE_INT);
    }
  }

  public int getValue() {
    return inputNumber;
  }

  private static void validatePositiveNumber(int number) {
    if (number < 0) {
      throw new IllegalArgumentException(NEGATIVE_NOT_ALLOWED);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Number number1 = (Number) o;
    return inputNumber == number1.inputNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputNumber);
  }
}
