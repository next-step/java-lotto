package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static void main(String[] args) {
    int result = splitAndSum("-1,2,3");
    System.out.println(result);
  }

  public static int splitAndSum(String value) {
    if (value == null || value.equals("")) {
      return 0;
    }

    if (value.length() == 1) {
      return Integer.parseInt(value);
    }

    isNegative(value);

    return addCalculator(value);
  }

  private static int addCalculator(String inputValue) {
    String[] values = inputValue.split("[^0-9]");
    return Arrays.stream(values)
            .mapToInt(StringAddCalculator::add)
            .sum();
  }

  private static int add(String value) {
    int sum = 0;
    if (isNumeric(value)) {
      sum += Integer.parseInt(value);
    }
    return sum;
  }

  private static boolean isNumeric(String value) {
    return value.matches("[0-9]");
  }

  public static void isNegative(String value) {
    Pattern pattern = Pattern.compile("-(?:[0-9])");
    Matcher matcher = pattern.matcher(value);

    if (matcher.find()) {
      throw new RuntimeException("입력값이 음수입니다.");
    }
  }
}
