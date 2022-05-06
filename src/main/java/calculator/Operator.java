package calculator;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
  PLUS("+", Operand::add),
  MINUS("-", Operand::subtract),
  MULTIPLICATION("*", Operand::multiply),
  DIVISION("/", Operand::divide);

  private final String sign;
  private final BiFunction<Operand, Operand, Operand> expression;

  Operator(String sign,
      BiFunction<Operand, Operand, Operand> expression) {
    this.sign = sign;
    this.expression = expression;
  }

  static Operator find(String sign) {
    return Stream.of(values())
        .filter(operator -> Objects.equals(operator.sign, sign))
        .findAny()
        .orElseThrow(
            () -> new IllegalArgumentException(String.format("%s 는 지원하지 않는 기호입니다.", sign)));
  }

  public static Operand operate(String sign, Operand a, Operand b) {
    Operator operator = Operator.find(sign);
    return operator.expression.apply(a, b);
  }
}
