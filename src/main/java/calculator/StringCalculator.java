package calculator;

import java.util.List;
import java.util.Objects;

public class StringCalculator {

  static final String EMPTY_EXCEPTION = "계산식을 입력하세요";

  public static Number calculate(String s) {
    Objects.requireNonNull(s);
    if (s.isBlank()) {
      throw new IllegalArgumentException(EMPTY_EXCEPTION);
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
    if (Objects.equals(operator, "+")) {
      return result.add(current);
    }

    if (Objects.equals(operator, "-")) {
      return result.subtract(current);
    }

    if (Objects.equals(operator, "*")) {
      return result.multiply(current);
    }

    if (Objects.equals(operator, "/")) {
      return result.divide(current);
    }

    return result;
  }
}
