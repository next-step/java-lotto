package calculator.domain.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum StringOperator {
  ADDITION("+"),
  SUBTRACTION("-"),
  DIVISION("/"),
  MULTIPLICATION("*");

  public static final String THIS_OPERATOR_IS_NOT_SUPPORTED = "%s(은)는 지원하지 않는 연산자 입니다. 입력 값을 다시 확인해주세요.";
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
        .orElseThrow(() -> new IllegalArgumentException(String.format(THIS_OPERATOR_IS_NOT_SUPPORTED, value)));
  }
}
