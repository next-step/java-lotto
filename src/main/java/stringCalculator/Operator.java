package stringCalculator;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public enum Operator {
  PLUS("+",(number1, number2) -> new Number(number1.value() + number2.value())),
  MINUS("-", (number1, number2) -> new Number(number1.value() - number2.value())),
  DIVISION("/", (number1, number2) -> new Number(number1.value() / number2.value())),
  MULTIPLICATION("*", (number1, number2) -> new Number(number1.value() * number2.value()));

  private final String operator;
  private final BinaryOperator<Number> calculate;

  Operator(String operator, BinaryOperator<Number> calculate) {
    this.operator = operator;
    this.calculate = calculate;
  }

  public static Operator from(String operator) {
    return Stream.of(values())
        .filter(op -> op.operator.equals(operator))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
  }

  public Number calculate(Number number1, Number number2) {
    return calculate.apply(number1, number2);
  }
}
