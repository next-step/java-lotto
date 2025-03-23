package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
  PLUS("+", (a, b) -> a + b),
  MINUS("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> a / b);

  private final String symbol;
  private final IntBinaryOperator operation;

  Operator(String symbol, IntBinaryOperator operation) {
    this.symbol = symbol;
    this.operation = operation;
  }

  public int apply(int left, int right) {
    return operation.applyAsInt(left, right);
  }

  public static Operator from(String symbol) {
    return Arrays.stream(values())
        .filter(op -> op.symbol.equals(symbol))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
  }
}
