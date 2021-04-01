package calculator;

import calculator.util.StringUtil;

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
  private final String delimiter;
  private final String numbers;

  private StringAdditionCalculator(String inputValue, String delimiter, String numbers) {
    this.inputValue = inputValue;
    this.delimiter = delimiter;
    this.numbers = numbers;
  }

  public static StringAdditionCalculator create(String inputValue) {
    return new StringAdditionCalculator(inputValue, getDelimiterRegexString(inputValue), getNumberString(inputValue));
  }

  public Integer sum() {
    if (StringUtil.isBlank(inputValue)) {
      return 0;
    }

    return stringToIntegerList(numbers, delimiter)
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
    if (StringUtil.isBlank(input)) {
      return "";
    }
    Matcher matcher = getMatcher(input);
    if (matcher.find()) {
      return matcher.group(2);
    }

    return input;
  }

  public static String getDelimiterRegexString(String inputValue) {
    String defaultDelimiter = Arrays.stream(DEFAULT_SEPARATORS)
            .collect(Collectors.joining("|"));

    if (StringUtil.isBlank(inputValue)) {
      return "";
    }

    String custom = getCustomDelimiter(inputValue);
    if (StringUtil.isBlank(custom)) {
      return defaultDelimiter;
    }

    return defaultDelimiter.concat("|").concat(custom);
  }

  public static String getCustomDelimiter(String input) {
    Matcher matcher = getMatcher(input);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return "";
  }

  private static Matcher getMatcher(String input) {
    return Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
  }
}
