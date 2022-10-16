package domain;

import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (a, b) -> a + b),
  MINUS("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> a / b);

  private final String Operator;
  private final BiFunction<Integer, Integer, Integer> calculateFunc;

  public Integer calculate(int a, int b) {
    return this.calculateFunc.apply(a, b);
  }

  Operator(final String Operator, BiFunction<Integer, Integer, Integer> calculateFunc) {
    this.Operator = Operator;
    this.calculateFunc = calculateFunc;
  }

}
