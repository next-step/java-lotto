package util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

  private StringUtils() {}

  private static final Pattern NUMERIC_PATTEN = Pattern.compile("-?\\d+");
  private static final List<String> ARITHMETIC_OPERATORS = List.of("+", "-", "%", "*");

  public static boolean isNotBlank (String input) {
    return !isBlank(input);
  }

  public static boolean isBlank (String input) {
    return input == null || input.isBlank();
  }

  public static boolean isDigit(String input) {
    Matcher matcher = NUMERIC_PATTEN.matcher(input);
    return matcher.matches();
  }

  public static boolean isArithmeticOperator(String input) {
    if (isBlank(input)) {
      return false;
    }

    return ARITHMETIC_OPERATORS.contains(input);
  }
}
