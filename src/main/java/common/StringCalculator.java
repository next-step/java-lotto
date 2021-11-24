package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
  private static final String DEFAULT_DELIMITERS = ":|,";

  public static int splitAndSum(String inputString) {
    if (Strings.isBlank(inputString)) {
      return 0;
    }

    Matcher customDelimiterPatternMatcher = CUSTOM_DELIMITER_PATTERN.matcher(inputString);
    if (customDelimiterPatternMatcher.find()) {
      String[] strings = splitStringsByCustomDelimiter(customDelimiterPatternMatcher);
      return sumStrings(strings);
    }

    return sumStrings(inputString.split(DEFAULT_DELIMITERS));
  }

  private static String[] splitStringsByCustomDelimiter(Matcher customDelimiterPatternMatcher) {
    String customDelimiter = customDelimiterPatternMatcher.group(1);
    return customDelimiterPatternMatcher.group(2).split(customDelimiter);
  }

  private static int sumStrings(String[] strings) {
    int result = 0;
    for (String string: strings) {
      result += Integer.parseInt(string);
    }
    return result;
  }

}
