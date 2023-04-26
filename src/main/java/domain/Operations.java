package domain;

import java.util.function.BiFunction;

public enum Operations {
  ADD("+", (a, b) -> a + b),
  SUBTRACT("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> a / b);

  private final String symbol;
  private final BiFunction<Integer, Integer, Integer> function;

  Operations(String symbol, BiFunction<Integer, Integer, Integer> function) {
    this.symbol = symbol;
    this.function = function;
  }

  public static Operations of(String symbol) {
    for (Operations operations : values()) {
      if (operations.symbol.equals(symbol)) {
        return operations;
      }
    }
    throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
  }


  public static int calculate(int number1, int number2, String operator) {
    Operations operation = Operations.of(operator);
    return operation.function.apply(number1, number2);
  }


}
