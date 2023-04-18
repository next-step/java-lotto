package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {
  ADDITION("+", (operand1, operand2) -> operand1 + operand2),
  SUBTRACTION("-", (operand1, operand2) -> operand1 - operand2),
  MULTIPLICATION("*", (operand1, operand2) -> operand1 * operand2),
  DIVISION("/", (operand1, operand2) -> {
    validateDivision(operand2);
    return operand1 / operand2;
  });

  private static final String ILLEGAL_OPERATOR_MESSAGE = "연산자 기호를 입력해주세요.";
  private static final String ILLEGAL_DIVISION_MESSAGE = "0으로 나눌 수 없습니다. 다른 숫자를 입력해주세요.";
  private static final Map<String, Operator> BY_OPERATOR = new HashMap<>();

  static {
    for (Operator operator : values()) {
      BY_OPERATOR.put(operator.operator, operator);
    }
  }

  private final String operator;
  private final BinaryOperator<Integer> calculation;

  Operator(final String operator, final BinaryOperator<Integer> calculation) {
    this.operator = operator;
    this.calculation = calculation;
  }

  public int applyCalculation(int operand1, int operand2) {
    return calculation.apply(operand1, operand2);
  }

  public static Operator valueOfOperator(String operator) {
    validateContainsKey(operator);

    return BY_OPERATOR.get(operator);
  }

  private static void validateDivision(int operand2) {
    if (operand2 == 0) {
      throw new IllegalArgumentException(ILLEGAL_DIVISION_MESSAGE);
    }
  }

  private static void validateContainsKey(String operator) {
    if (!BY_OPERATOR.containsKey(operator)) {
      throw new IllegalArgumentException(ILLEGAL_OPERATOR_MESSAGE);
    }
  }
}
