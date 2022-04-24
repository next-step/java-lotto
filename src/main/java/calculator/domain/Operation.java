package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.IntBinaryOperator;

public enum Operation {
  ADD("+", (a, b) -> a + b),
  SUBTRACT("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> {
    if (b == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
    return a / b;
  });

  private final String operator;
  private final IntBinaryOperator binaryOperator;

  private static final Map<String, Operation> BY_OPERATOR = new HashMap<>();
  static {
    for (Operation e : values()) {
      BY_OPERATOR.put(e.operator, e);
    }
  }

  Operation(String operator, IntBinaryOperator binaryOperator) {
    this.operator = operator;
    this.binaryOperator = binaryOperator;
  }

  public int apply(int a, int b) {
    return binaryOperator.applyAsInt(a, b);
  }

  public static Operation valueOfOperator(String operator) {
    Operation operation = BY_OPERATOR.get(operator);
    if (operation == null) {
      throw new IllegalArgumentException("올바른 연산자가 아닙니다. (+, -, *, /)");
    }
    return operation;
  }

  public static Set<String> getOperatorSet() {
    return BY_OPERATOR.keySet();
  }
}
