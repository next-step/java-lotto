package calculator;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
  PLUS("+", Number::add),
  MINUS("-", Number::subtract),
  MULTIPLICATION("*", Number::multiply),
  DIVISION("/", Number::divide);

  private final String sign;
  private final BiFunction<Number, Number, Number> expression;

  Operator(String sign,
      BiFunction<Number, Number, Number> expression) {
    this.sign = sign;
    this.expression = expression;
  }

  public static Operator find(String sign) {
    return Stream.of(values())
        .filter(operator -> Objects.equals(operator.sign, sign))
        .findAny()
        .orElseThrow(
            () -> new IllegalArgumentException(String.format("%s 는 지원되지 않는 기호입니다.", sign)));
  }

  public static Number operate(Operator operator, Number a, Number b) {
    return operator.expression.apply(a, b);
  }
}
