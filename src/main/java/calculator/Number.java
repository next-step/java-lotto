package calculator;

import java.util.Objects;

public class Number {
  private static final String POSITIVE_NUMBER_REGEX = "[+]?\\d*(\\.\\d+)?";

  private final int number;

  private Number(int number) {
    this.number = number;
  }

  public static Number create(int number) {
    return new Number(number);
  }

  public static Number zero() {
    return Number.create(0);
  }

  public static Number positiveValueOf(String str) {
    if (!isPositiveNumberString(str)) {
      throw new RuntimeException(String.format("입력 값(%s)에 숫자 이외의 문자열 또는 음수를 입력할 수 없습니다.", str));
    }

    return Number.create(Integer.parseInt(str));
  }

  public Number sum(Number other) {
    return new Number(number + other.number);
  }

  private static boolean isPositiveNumberString(String str) {
    return str.matches(POSITIVE_NUMBER_REGEX);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Number number1 = (Number) o;
    return number == number1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
