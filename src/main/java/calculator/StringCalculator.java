package calculator;

import java.util.Arrays;

public class StringCalculator {


  public static int calculate(String input) throws Exception {
    if (isBlank(input)) {
      return 0;
    }
    String[] tokens = separate(input);
    Validator.validate(tokens);
    return sum(tokens);
  }

  private static String[] separate(String input) {
    if (CustomSeparator.isCustomSeparatorCase(input)) {
      return CustomSeparator.separate(input);
    }
    return DefaultSeparator.separate(input);
  }

  private static int sum(String[] tokens) {
    return Arrays.stream(tokens)
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static boolean isBlank(String input) {
    return input == null || "".equals(input.trim());
  }
}
