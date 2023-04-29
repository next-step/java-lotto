package calculator.domain;

import calculator.domain.parser.CalculatorElementSplitter;
import calculator.domain.parser.SingleBlankElementSplitter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;
import util.StringUtils;

public class CalculatorExpressionParser {

  private final CalculatorElementSplitter splitter;

  public CalculatorExpressionParser() {
    this.splitter = new SingleBlankElementSplitter();
  }

  public ArrayDeque<String> parse (String expression) {
    if (StringUtils.isBlank(expression)) {
      throw new IllegalArgumentException();
    }

    return Arrays.stream(splitter.split(expression))
        .map(String::strip)
        .collect(Collectors.toCollection(ArrayDeque::new));
  }
}
