package calculator;

public class StringCalculator {


  public static int calculate(String input) throws Exception {
    if (isBlank(input)) {
      return 0;
    }
    Tokens tokens = separate(input);
    return tokens.sum();
  }

  private static Tokens separate(String input) throws Exception {
    if (CustomSeparator.isCustomSeparatorCase(input)) {
      return CustomSeparator.separate(input);
    }
    return DefaultSeparator.separate(input);
  }


  private static boolean isBlank(String input) {
    return input == null || "".equals(input.trim());
  }
}
