package step1;

import static step1.constans.RxPattern.CUSTOM_DELIMITER_PATTERN;
import static step1.utils.StringUtils.ZERO;
import static step1.utils.StringUtils.isEmpty;

import step1.domain.CustomOperation;
import step1.domain.DefaultOperation;
import step1.domain.Operation;

public class Calculator {

  private Calculator() {}

  public static int calculate(String inputValue) {
    if (isEmpty(inputValue)) {
      return ZERO;
    }
    Operation operation = resolveOperation(inputValue);

    return operation.sum();
  }

  private static Operation resolveOperation(String inputValue) {
    if (isCustomDelimiterPattern(inputValue)) {
      return new CustomOperation(inputValue);
    }

    return new DefaultOperation(inputValue);

  }

  private static boolean isCustomDelimiterPattern(String input) {
    return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
  }
}
