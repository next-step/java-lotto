package stringCalculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

  private static final String DEFAULT_DELIMETER = ",|:";
  private static Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

  public static String[] split(String input) {
    if (PATTERN == null) {
      PATTERN = Pattern.compile("//(.)\n(.*)");
    }

    Matcher matcher = PATTERN.matcher(input);
    if (matcher.find()) {
      String customDelimeter = matcher.group(1);
      return matcher.group(2).split(customDelimeter);
    }
    return input.split(DEFAULT_DELIMETER);
  }
}
