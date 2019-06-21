package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

  private static final String DELIMITER_PATTERN = "//(.)\n(.*)";
  private static final Pattern PATTERNS = Pattern.compile(DELIMITER_PATTERN);
  private static final String CUSTOM_DELIMITER_START = "//";
  private static final String DELIMITER = "[,:]";
  private static final String DEFAULT_VALUE = "0";

  public static Numbers split(String input) {
    if (validateInput(input)) {
      return new Numbers(Collections.singletonList(DEFAULT_VALUE));
    }

    if (isCustomDelimiter(input)) {
      return splitCustom(input);
    }

    return new Numbers(Arrays.asList(input.split(DELIMITER)));
  }

  public static Numbers splitCustom(String input) {
    Matcher matcher = PATTERNS.matcher(input);
    if (matcher.find()) {
      return new Numbers(Arrays.asList(getStrings(matcher)));
    }

    throw new IllegalArgumentException("잘못된 입력입니다. : " + input);
  }

  private static String[] getStrings(Matcher matcher) {
    String customDelimiter = matcher.group(1);
    return matcher.group(2).split(customDelimiter);
  }

  public static boolean isCustomDelimiter(String input) {
    return input.startsWith(CUSTOM_DELIMITER_START);
  }

  public static boolean validateInput(String input) {
    return input == null || input.isEmpty();
  }
}
