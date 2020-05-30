package stringaddcalculator;

import java.util.regex.Pattern;

public class PlusCalculator implements StringArrayCalculator {

  private final static String MINUS = "-";
  private final static Pattern NOT_NUMBER = Pattern.compile("\\D");

  public int calculate(String[] numberArr) {
    int result = 0;

    for (String number : numberArr) {
      checkIsNegative(number);
      checkIsNumber(number);

      result += Integer.parseInt(number);
    }

    return result;
  }

  private void checkIsNegative(String s) {
    if (s.startsWith(MINUS)) {
      throw new RuntimeException();
    }
  }

  private void checkIsNumber(String s) {
    if (NOT_NUMBER.matcher(s).find()) {
      throw new RuntimeException();
    }
  }
}
