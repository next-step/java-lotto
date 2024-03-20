package calculator.domain.type;

import calculator.domain.strategy.*;

import java.util.Arrays;
import java.util.Map;

public enum StringOperator {
  ADDITION("+"),
  SUBTRACTION("-"),
  DIVISION("/"),
  MULTIPLICATION("*");

  public static final String THIS_OPERATOR_IS_NOT_SUPPORTED = "%s(은)는 지원하지 않는 연산자 입니다. 입력 값을 다시 확인해주세요.";
  public static final Map<StringOperator, CalculateStrategy> OPERATIONS = Map.of(
      ADDITION, new AdditionStrategy(),
      SUBTRACTION, new SubtractionStrategy(),
      MULTIPLICATION, new MultiplicationStrategy(),
      DIVISION, new DivisionStrategy()
  );

  private final String operator;

  StringOperator(String operator) {
    this.operator = operator;
  }

  public static StringOperator convert(String value) {
    return Arrays.stream(StringOperator.values())
        .filter(it -> it.operator.equals(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(String.format(THIS_OPERATOR_IS_NOT_SUPPORTED, value)));
  }
}
