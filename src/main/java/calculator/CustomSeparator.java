package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator {

  private final static int CUSTOM_DELIMITER_INDEX = 1;
  private final static int CUSTOM_TEXT_GROUP_INDEX = 2;

  public static Tokens separate(String input) throws Exception {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
    if (!m.find()) {
      return new Tokens(new String[]{});
    }
    String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
    String[] numbers = m.group(CUSTOM_TEXT_GROUP_INDEX).split(customDelimiter);
    return new Tokens(numbers);
  }

  public static boolean isCustomSeparatorCase(String input) {
    return input.startsWith("//");
  }

}
