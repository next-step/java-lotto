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
    return input.matches(Constant.NUMBER_REGEX);
  }

  public static void validateNumber(String input) {
    isCalculableNumber(input);
    isNegativeNumber(input);
  }

  public static void isCalculableNumber(String input) {
    if (!input.matches(Constant.NUMBER_REGEX)) {
      throw new RuntimeException("양수만 계산할 수 있습니다.");
    }
  }

  public static void isNegativeNumber(String input) {
    if (Integer.parseInt(input) < 0) {
      throw new RuntimeException("양수만 계산할 수 있습니다.");
    }
  }
}
