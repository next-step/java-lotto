package calculator;

import java.util.List;
import java.util.Objects;

public class StringCalculator {

  static final String EMPTY_EQUATION_MESSAGE = "계산식을 입력하세요";
  static final String INVALID_OPERATOR_MESSAGE = "사칙연산 기호가 아닙니다.";

  private static final String SIGN_ADD = "+";
  private static final String SIGN_SUBTRACT = "-";
  private static final String SIGN_MULTIPLY = "*";
  private static final String SIGN_DIVIDE = "/";

  public static Number calculate(String s) {
    Objects.requireNonNull(s);
    if (s.isBlank()) {
      throw new IllegalArgumentException(EMPTY_EQUATION_MESSAGE);
    }

    List<String> strings = Splitter.from(s);
    Number result = Number.from(strings.get(0));
    int size = strings.size();
    for (int i = 1; i < size - 1; i = i + 2) {
      String operator = strings.get(i);
      Number current = Number.from(strings.get(i + 1));
      result = calculate(operator, result, current);
    }
    return result;
  }

  private static Number calculate(String operator, Number result, Number current) {
    if (Objects.equals(operator, SIGN_ADD)) {
      return result.add(current);
    }

    if (Objects.equals(operator, SIGN_SUBTRACT)) {
      return result.subtract(current);
    }

    if (Objects.equals(operator, SIGN_MULTIPLY)) {
      return result.multiply(current);
    }

    if (Objects.equals(operator, SIGN_DIVIDE)) {
      return result.divide(current);
    }

    throw new IllegalArgumentException(INVALID_OPERATOR_MESSAGE);
  }
}
