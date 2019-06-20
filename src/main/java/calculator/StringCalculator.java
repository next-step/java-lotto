package calculator;

import calculator.utils.StringUtils;
import java.util.Arrays;

public class StringCalculator {

  public static final String STRING_CALCULATOR_DELIIMITER = ",|:";

  public static int calculate(String input) {
    if (isBlank(input)) {
      return 0;
    }
    String[] numbers = StringUtils.splitInputValue(STRING_CALCULATOR_DELIIMITER, input);
    return sum(numbers);
  }

  private static int sum(String[] numbers) {
    return Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static boolean isBlank(String input) {
    return input == null || "".equals(input.trim());
  }
}
