package step1;

import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (x, y) -> x + y),
  MINUS("-", (x, y) -> x - y),
  MULTIPLICATION("*", (x, y) -> x * y),
  DIVISION("/", (x, y) -> x / y);

  private String operator;
  private BiFunction<Integer, Integer, Integer> expression;

  Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  int calculate(int firstNum, int secondNum) {
    return expression.apply(firstNum, secondNum);
  }
}
