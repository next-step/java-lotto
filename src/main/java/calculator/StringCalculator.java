package calculator;

import java.util.Arrays;

public class StringCalculator {


  public static int calculate(String input) {
    if (isBlank(input)) {
      return 0;
    }
    String[] numbers = separate(input);
    return sum(numbers);
  }

  private static String[] separate(String input) {
    if (CustomSeparator.isCustomSeparatorCase(input)) {
      return CustomSeparator.separate(input);
    }
    return DefaultSeparator.separate(input);
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
