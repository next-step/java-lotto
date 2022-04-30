package calculator.domain;

import calculator.exception.InvalidOperatorException;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (num1, num2) -> new Number(num1.getNumber() + num2.getNumber())),
  MINUS("-", (num1, num2) -> new Number(num1.getNumber() - num2.getNumber())),
  MULTIPLY("*", (num1, num2) -> new Number(num1.getNumber() * num2.getNumber())),
  DIVIDE("/", (num1, num2) -> new Number(num1.getNumber() / num2.getNumber()));

  private final String operator;
  private final BiFunction<Number, Number, Number> function;

  private Operator(String operator, BiFunction<Number, Number, Number> function) {
    this.operator = operator;
    this.function = function;
  }

  public static Operator getOperator(String operator) {
    return Arrays.stream(values())
        .filter(operatorEnum -> operatorEnum.operator.equals(operator))
        .findAny().orElseThrow(() -> new InvalidOperatorException("잘못된 연산자입니다. 연산자 : " + operator));
  }

  public Number operate(Number number1, Number number2) {
    return function.apply(number1, number2);
  }

}
