package calculator.controller;

import calculator.domain.Expression;

public class Calculator {

  private static final Calculator INSTANCE = new Calculator();

  private Calculator() {
  }

  public static Calculator getInstance() {
    return INSTANCE;
  }

  public int calculate(String expression) {
    return Expression.from(expression).calculate();
  }
}
