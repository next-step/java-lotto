package stringcalculator.util;

public class IntConverter {

  private static final String NUMBER_REGEX = "-?\\d+";

  private IntConverter() {
  }

  public static int convert(String input) {
    if (!input.matches(NUMBER_REGEX)) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    return Integer.parseInt(input);
  }
}
