package calculator.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;
import util.StringUtils;

public class CalculatorExpressionParser {

  public ArrayDeque<String> parse (String expression) {
    if (StringUtils.isBlank(expression)) {
      throw new IllegalArgumentException();
    }

    return Arrays.stream(expression.split(" "))
        .map(String::strip)
        .collect(Collectors.toCollection(ArrayDeque::new));
  }
}
