package calculator;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAdditionCalculator {
  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

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

  public Number sum() {
    return positiveNumberList(numbers, delimiter)
            .stream()
            .reduce(Number::sum)
            .orElse(Number.zero());
  }

  public static List<Number> positiveNumberList(String text, Delimiter delimiter) {
    return Arrays.stream(text.split(delimiter.getDelimiter()))
            .map(Number::positiveValueOf)
            .collect(Collectors.toList());
  }

  public static String getNumberString(String input) {
    return StringUtil.defaultBlankString(StringUtil.findGroup(input, CUSTOM_DELIMITER_REGEX, 2), input);
  }
}
