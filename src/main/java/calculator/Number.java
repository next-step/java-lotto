package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Number {

  private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d");
  private final int number;

  public static Number from(String value) {
    validateInputValue(value);
    validateNumberFormat(value);
    return new Number(Integer.parseInt(value));
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

  private Number(int number) {
    this.number = number;
  }

  int number() {
    return number;
  }

  Number add(Number target) {
    return new Number(number + target.number);
  }

  Number subtract(Number target) {
    return new Number(number - target.number);
  }

  Number multiply(Number target) {
    return new Number(number * target.number);
  }

  Number divide(Number target) {
    return new Number(number / target.number);
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
    Number number = (Number) o;
    return this.number == number.number;
  }
}
