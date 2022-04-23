package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

public enum Operation {
  ADD("+", (a, b) -> {
    validateNull(a, b);
    return a + b;
  }),
  SUBTRACT("-", (a, b) -> {
    validateNull(a, b);
    return a - b;
  }),
  MULTIPLY("*", (a, b) -> {
    validateNull(a, b);
    return a * b;
  }),
  DIVIDE("/", (a, b) -> {
    validateNull(a, b);
    if (b == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
    return a / b;
  });

  private final String operator;
  private final BinaryOperator<Integer> binaryOperator;

  private static final Map<String, Operation> BY_OPERATOR = new HashMap<>();
  static {
    for (Operation e : values()) {
      BY_OPERATOR.put(e.operator, e);
    }
  }

  Operation(String operator, BinaryOperator<Integer> binaryOperator) {
    this.operator = operator;
    this.binaryOperator = binaryOperator;
  }

  public Integer apply(Integer a, Integer b) {
    return binaryOperator.apply(a, b);
  }

  public static Operation valueOfOperator(String operator) {
    return BY_OPERATOR.get(operator);
  }

  public static Set<String> getOperatorSet() {
    return BY_OPERATOR.keySet();
  }

  private static void validateNull(Integer a, Integer b) {
    if (a == null || b == null) {
      throw new IllegalArgumentException("계산할 수 없는 값입니다. (ex. null)");
    }
  }
}
