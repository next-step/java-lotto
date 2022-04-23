package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Calculator {

  private static final String EMPTY_INPUT_MESSAGE = "계산할 문자열을 입력해주세요.";
  private static final String INVALID_INPUT_MESSAGE = "올바른 계산식을 입력해주세요.";
  private static final String DELIMITER = " ";

  private final List<String> values;

  public Calculator(String input) {
    this(split(input));
  }

  public Calculator(List<String> values) {
    this.values = values;
  }

  public Integer calculate() {
    Integer result = Integer.parseInt(values.get(0));
    for (int i = 1; i < values.size() - 1; i += 2) {
      Operation operation = Operation.valueOfOperator(values.get(i));
      result = operation.apply(result, Integer.parseInt(values.get(i + 1)));
    }
    return result;
  }

  private static List<String> split(String input) {
    validateInput(input);
    List<String> splited = Arrays.asList(input.split(DELIMITER));
    validateSplitedSize(splited);
    return splited;
  }

  private static void validateInput(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
    }
  }

  private static void validateSplitedSize(List<String> splited) {
    if (splited.size() % 2 == 0) {
      throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
    }
  }
}
