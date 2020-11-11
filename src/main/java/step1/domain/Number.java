package step1.domain;

import static step1.constans.Message.INPUT_FORMAT_ERROR;
import static step1.constans.Message.NEGATIVE_NOT_ALLOWED;
import static step1.utils.StringUtils.ZERO;

import java.util.Objects;
import step1.exception.AdderException;

public class Number {
  public static final Number ZERO_NUMBER = new Number(ZERO);

  private final int number;

  public Number(String inputVal) {
    try {
      int number = Integer.parseInt(inputVal);
      validatePositiveNumber(number);
      this.number = number;
    } catch (NumberFormatException e) {
      throw new AdderException(INPUT_FORMAT_ERROR);
    }
  }

  public Number(int number) {
    validatePositiveNumber(number);
    this.number = number;
  }

  public int intValue() {
    return number;
  }

  public static Number sum(Number o1, Number o2) {
    return new Number(o1.number + o2.number);
  }

  private void validatePositiveNumber(int number) {
    if (number < ZERO) {
      throw new AdderException(NEGATIVE_NOT_ALLOWED);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Number number1 = (Number) o;
    return number == number1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
