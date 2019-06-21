package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  public static int splitAndSum(String input) {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
    int result = 0;
    if (m.find()) {
      String customDelimeter = m.group(1);
      String[] numbers= m.group(2).split(customDelimeter);
      for (String number : numbers) {
        result += Integer.valueOf(number.trim());
      }
    } else {
      String[] numbers = input.split("[,:]");
      for (String number : numbers) {
        result += Integer.valueOf(number.trim());
      }
    }

    return result;
  }
}
