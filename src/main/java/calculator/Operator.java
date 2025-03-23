package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
  PLUS("+", (a, b) -> a + b),
  MINUS("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> safeDivide(a, b));

  private final String symbol;
  private final IntBinaryOperator operation;

  Operator(String symbol, IntBinaryOperator operation) {
    this.symbol = symbol;
    this.operation = operation;
  }

  public static Operator from(String symbol) {
    return Arrays.stream(values())
            .filter(op -> op.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
  }

  public int apply(int left, int right) {
    return operation.applyAsInt(left, right);
  }

  private static int safeDivide(int left, int right) {
    if (right == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
    return left / right;
  }
}
