package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Operand {

  private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d");

  private final int number;

  public static Operand createOperand(String value) {
    validateInputValue(value);
    validateNumberFormat(value);
    return new Operand(Integer.parseInt(value));
  }

  private static void validateInputValue(String value) {
    if (value == null || value.isBlank()) {
      throw new IllegalArgumentException("숫자 객체는 빈 값일 수 없습니다.");
    }
  }

  private static void validateNumberFormat(String value) {
    Matcher m = NUMBER_PATTERN.matcher(value);
    if (!m.find()) {
      throw new NumberFormatException(String.format("%s 지원하지 않는 숫자 형식입니다", value));
    }
  }

  private Operand(int number) {
    this.number = number;
  }

  int number() {
    return number;
  }

  Operand add(Operand target) {
    return new Operand(number + target.number);
  }

  Operand subtract(Operand target) {
    return new Operand(number - target.number);
  }

  Operand multiply(Operand target) {
    return new Operand(number * target.number);
  }

  Operand divide(Operand target) {
    return new Operand(number / target.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operand operand = (Operand) o;
    return this.number == operand.number;
  }
}
