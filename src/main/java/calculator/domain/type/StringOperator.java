package calculator.domain.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum StringOperator {
  ADDITION("+"),
  SUBTRACTION("-"),
  DIVISION("/"),
  MULTIPLICATION("*");

  private static final List<String> ALL_OPERATORS = Arrays.stream(StringOperator.values()).map(it -> it.operator).collect(Collectors.toList());
  private final String operator;

  StringOperator(String operator) {
    this.operator = operator;
  }

  public static List<String> allOperators() {
    return ALL_OPERATORS;
  }

  public static StringOperator convert(String value) {
    return Arrays.stream(StringOperator.values())
        .filter(it -> it.operator.equals(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("변환 가능한 연산자가 존재하지 않습니다."));
  }

  public String getOperator() {
    return operator;
  }
}
