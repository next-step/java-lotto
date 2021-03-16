package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public int splitAndSum(String input) {
    if (InputValidator.isEmptyOrBlank(input)) {
      return 0;
    }

    if (InputValidator.isSingleNumber(input)) {
      return Integer.parseInt(input);
    }

    return calculate(input);
  }

  public int calculate(String input) {
    String[] numbers = splitString(input);
    int result = 0;

    for (int i = 0; i < numbers.length; i++) {
      InputValidator.validateNumber(numbers[i]);
      result += Integer.parseInt(numbers[i]);
    }

    return result;
  }

  public String[] splitString(String text) {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }
    return text.split(",|:");
  }
}
