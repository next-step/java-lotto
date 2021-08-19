package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static int splitAndSum(String input) {
    if (input == null || input.equals("")) {
      return 0;
    }
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
    if (m.find()) {
      return getSumResult(m.group(2), m.group(1));
    }
    return getSumResult(input, ",:");
  }

  private static int getSumResult(String input, String delemiter) {
    String[] tokens = input.split("[" + delemiter + "]");
    int result = 0;
    for (String token : tokens) {
      int num = Integer.parseInt(token);
      if (num < 0) {
        throw new RuntimeException("음수 값은 사용될 수 없습니다.");
      }
      result += num;
    }
    return result;
  }
}
