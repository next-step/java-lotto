package calculator;

public class InputValidator {

  public static boolean isEmptyOrBlank(String input) {
    if (isEmpty(input) || isBlank(input)) {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(String input) {
    return "".equals(input);
  }

  public static boolean isBlank(String input) {
    return input == null;
  }

  public static boolean isSingleNumber(String input) {
    return input.matches("^[0-9]*$");
  }

  public static void validateNumber(String input) {
    isCalculableNumber(input);
    isNegative(input);
  }

  public static void isCalculableNumber(String input) {
    if (!input.matches("^[0-9]*$")) {
      throw new RuntimeException("양수만 계산할 수 있습니다.");
    }
  }

  public static void isNegative(String input) {
    if (Integer.parseInt(input) < 0) {
      throw new RuntimeException("양수만 계산할 수 있습니다.");
    }
  }
}
