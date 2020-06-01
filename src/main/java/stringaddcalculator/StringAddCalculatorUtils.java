package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatorUtils {

  private final static String COMMA = ",";
  private final static String COLON = ":";
  private final static String OR = "|";
  private final static String PREFIX_CUSTOM_DELIMITER = "//";
  private final static String POSTFIX_CUSTOM_DELIMITER = "\n";

  private final static Pattern SPLIT_NUMBER = Pattern.compile(COMMA + OR + COLON);
  private final static Pattern FIND_CUSTOM_DELIMITER = Pattern
      .compile("(?<=" + PREFIX_CUSTOM_DELIMITER + ").(?=" + POSTFIX_CUSTOM_DELIMITER + ")");

  public static boolean isNullOrEmpty(String s) {
    return s == null || s.trim().length() == 0;
  }

  public static String[] splitNumbers(String s) {
    String customDelimiter = findCustomDelimiter(s);

    if (customDelimiter.isEmpty()) {
      return SPLIT_NUMBER.split(s);
    }

    return s.replace(PREFIX_CUSTOM_DELIMITER + customDelimiter + POSTFIX_CUSTOM_DELIMITER, "")
        .split(SPLIT_NUMBER.pattern() + OR + customDelimiter);
  }

  public static String findCustomDelimiter(String s) {
    Matcher matcher = FIND_CUSTOM_DELIMITER.matcher(s);

    if (matcher.find()) {
      return matcher.group();
    }

    return "";
  }
}
