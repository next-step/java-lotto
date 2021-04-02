package calculator;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Delimiter {
  private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
  private static final String[] DEFAULT_SEPARATORS = new String[]{ ",", ":" };
  private static final String SPLIT_REGEX_DELIMITER = "|";
  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

  private final String delimiter;

  public Delimiter(String delimiter) {
    this.delimiter = delimiter;
  }

  public static Delimiter createDelimiterRegexString(String input) {
    return new Delimiter(generateDelimiterRegexString(input));
  }

  private static String generateDelimiterRegexString(String inputValue) {
    StringBuffer sb = new StringBuffer(getDefaultDelimiterString());
    String custom = getCustomDelimiter(inputValue);
    return StringUtil.isBlank(custom) ? sb.toString()
            : sb.append(SPLIT_REGEX_DELIMITER)
                .append(custom)
                .toString();
  }

  private static String getDefaultDelimiterString() {
    return Arrays.stream(DEFAULT_SEPARATORS)
            .collect(Collectors.joining(SPLIT_REGEX_DELIMITER));
  }

  private static String getCustomDelimiter(String input) {
    return StringUtil.findGroup(input, CUSTOM_DELIMITER_REGEX, CUSTOM_DELIMITER_GROUP_INDEX);
  }

  public String getDelimiter() {
    return delimiter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Delimiter delimiter1 = (Delimiter) o;
    return Objects.equals(delimiter, delimiter1.delimiter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delimiter);
  }
}
