package calculator.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

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
}
