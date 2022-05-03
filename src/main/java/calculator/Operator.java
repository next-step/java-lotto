package calculator;

import java.util.Objects;
import java.util.stream.Stream;

public enum Operator {
  PLUS("+"),
  MINUS("-"),
  MULTIPLICATION("*"),
  DIVISION("/");

  private final String sign;

  Operator(String sign) {
    this.sign = sign;
  }

  public static Operator find(String sign) {
    return Stream.of(values())
        .filter(operator -> Objects.equals(operator.sign, sign))
        .findAny()
        .orElseThrow(
            () -> new IllegalArgumentException(String.format("%s 는 지원되지 않는 기호입니다.", sign)));
  }

  public static Number operate(Operator operator, Number a, Number b) {
    if (operator == PLUS) {
      return a.add(b);
    }

    if (operator == MINUS) {
      return a.subtract(b);
    }

    if (operator == MULTIPLICATION) {
      return a.multiply(b);
    }

    if (operator == DIVISION) {
      return a.divide(b);
    }

    return a;
  }
}
