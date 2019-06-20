package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator {
  private final static int CUSTOM_DELIMITER_INDEX =1;
  private final static int CUSTOM_TEXT_GROUP_INDEX =2;

  public static String[] separate(String input) {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
    if (!m.find()) {
      return new String[]{};
    }
    String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
    String[] numbers = m.group(CUSTOM_TEXT_GROUP_INDEX).split(customDelimiter);
    return numbers;
  }
}
