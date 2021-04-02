package calculator;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAdditionCalculator {
  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
  private static final String POSITIVE_NUMBER_REGEX = "[+]?\\d*(\\.\\d+)?";

  private final Delimiter delimiter;
  private final String numbers;

  private StringAdditionCalculator(Delimiter delimiter, String numbers) {
    this.delimiter = delimiter;
    this.numbers = numbers;
  }

  public static StringAdditionCalculator create(String inputValue) {
    final String input = StringUtil.defaultBlankString(inputValue, "0");
    return new StringAdditionCalculator(Delimiter.createDelimiterRegexString(input), getNumberString(input));
  }

  public Integer sum() {
    return stringToIntegerList(numbers, delimiter)
            .stream()
            .reduce(Integer::sum)
            .orElse(0);
  }

  public static List<Integer> stringToIntegerList(String text, Delimiter delimiter) {
    return Arrays.stream(text.split(delimiter.getDelimiter()))
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
    return StringUtil.defaultBlankString(StringUtil.findGroup(input, CUSTOM_DELIMITER_REGEX, 2), input);
  }
}
