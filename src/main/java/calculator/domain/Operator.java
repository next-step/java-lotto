package calculator.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public enum Operator {
  PLUS("+", (a, b) -> a + b),
  MINUS("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", Operator::safeDivide);

  private final String symbol;
  private final IntBinaryOperator operation;

  Operator(String symbol, IntBinaryOperator operation) {
    this.symbol = symbol;
    this.operation = operation;
  }

  private static final Map<String, Operator> SYMBOL_MAP = Arrays.stream(values())
          .collect(Collectors.toMap(op -> op.symbol, op -> op));

  public static Operator from(String symbol) {
    Operator operator = SYMBOL_MAP.get(symbol);
    if (operator == null) {
      throw new IllegalArgumentException("잘못된 연산자입니다: " + symbol);
    }
    return operator;
  }

  public int apply(int left, int right) {
    return operation.applyAsInt(left, right);
  }

  private static int safeDivide(int left, int right) {
    if (right == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
    return left / right;
  }
}
