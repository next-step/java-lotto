package calculator;

import java.util.List;
import java.util.Objects;

public class StringCalculator {

  static final String EMPTY_EQUATION_MESSAGE = "계산식을 입력하세요";

  private static final int FIRST_INDEX = 0;

  public static Number calculate(String s) {
    validateInput(s);

    List<String> strings = Splitter.split(s);
    Number result = Number.createNumber(strings.get(FIRST_INDEX));
    int size = strings.size();
    for (int i = 1; i < size - 1; i = i + 2) {
      String sign = strings.get(i);
      Operator operator = Operator.find(sign);
      Number current = Number.createNumber(strings.get(i + 1));
      result = Operator.operate(operator, result, current);
    }
    return result;
  }

  private static void validateInput(String s) {
    Objects.requireNonNull(s);
    if (s.isBlank()) {
      throw new IllegalArgumentException(EMPTY_EQUATION_MESSAGE);
    }
  }
}
