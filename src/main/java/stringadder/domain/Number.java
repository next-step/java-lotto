package stringadder.domain;

import java.util.Objects;

public class Number {

  public static final int ZERO = 0;

  public static final Number ZERO_NUMBER = new Number(ZERO);

  private static final String NEGATIVE_NOT_ALLOWED = "숫자는 양수로 입력해주세요.";

  private static final String PLEASE_INPUT_POSITIVE_INT = "더할 숫자는 자연수로 입력해주세요.";

  private final int inputNumber;

  public Number(String input) {
    try {
      int number = Integer.parseInt(input);
      validatePositiveNumber(number);
      this.inputNumber = number;
    } catch (NumberFormatException e) {
      e.printStackTrace();
      throw new IllegalArgumentException(PLEASE_INPUT_POSITIVE_INT);
    }
  }

  public Number(int inputNumber) {
    validatePositiveNumber(inputNumber);
    this.inputNumber = inputNumber;
  }

  private void validatePositiveNumber(int number) {
    if(number < ZERO) {
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
