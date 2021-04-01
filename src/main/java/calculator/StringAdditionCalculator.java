package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAdditionCalculator {
  private static final String[] DEFAULT_SEPARATORS = new String[]{ ",", ":" };
  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
  private static final String POSITIVE_NUMBER_REGEX = "[+]?\\d*(\\.\\d+)?";

  private final String inputValue;

  private StringAdditionCalculator(String inputValue) {
    this.inputValue = inputValue;
  }

  public static StringAdditionCalculator create(String inputValue) {
    return new StringAdditionCalculator(inputValue);
  }

  public Integer sum() {
    if (isBlank(inputValue)) {
      return 0;
    }

    if (existCustomDelimiter(inputValue)) {
      String delimiter = getDelimiterRegexString().concat("|")
              .concat(getCustomDelimiter(inputValue));
      String numbers = getNumberString(inputValue);
      return stringToIntegerList(numbers, delimiter)
              .stream()
              .reduce(Integer::sum)
              .orElse(0);
    }

    return stringToIntegerList(inputValue, getDelimiterRegexString())
            .stream()
            .reduce(Integer::sum)
            .orElse(0);
  }

  public static List<Integer> stringToIntegerList(String text, String delimiter) {
    return Arrays.stream(text.split(delimiter))
            .map(str -> {
              if (isPositiveNumberString(str)) {
                return Integer.parseInt(str);
              }
              throw new RuntimeException(String.format("입력 값(%s)에 숫자 이외의 문자열 또는 음수를 입력할 수 없습니다.", str));
            })
            .collect(Collectors.toList());
  }

  public static boolean isPositiveNumberString(String str) {
    return str.matches(POSITIVE_NUMBER_REGEX);
  }

  public static String getNumberString(String input) {
    Matcher matcher = getMatcher(CUSTOM_DELIMITER_REGEX, input);
    if (matcher.find()) {
      return matcher.group(2);
    }

    return input;
  }

  public static boolean existCustomDelimiter(String text) {
    return getMatcher(CUSTOM_DELIMITER_REGEX, text).find();
  }

  public static String getCustomDelimiter(String text) {
    Matcher matcher = getMatcher(CUSTOM_DELIMITER_REGEX, text);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return "";
  }

  public static Matcher getMatcher(String regex, String text) {
    return Pattern.compile(regex).matcher(text);
  }

  private static String getDelimiterRegexString() {
    return Arrays.stream(DEFAULT_SEPARATORS)
            .collect(Collectors.joining("|"));
  }

  private static boolean isBlank(String str) {
    return str == null || str.isEmpty() || str.trim().isEmpty();
  }
}
