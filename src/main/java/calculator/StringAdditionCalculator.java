package calculator;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAdditionCalculator {
  private final Delimiter delimiter;
  private final NumberString numberString;

  private StringAdditionCalculator(Delimiter delimiter, NumberString numberString) {
    this.delimiter = delimiter;
    this.numberString = numberString;
  }

  public static StringAdditionCalculator create(String inputValue) {
    final String blankSafeString = StringUtil.defaultBlankString(inputValue, "0");
    return new StringAdditionCalculator(Delimiter.createDelimiterRegexString(blankSafeString), NumberString.generateNumberString(blankSafeString));
  }

  public Number sum() {
    return positiveNumberList(numberString, delimiter)
            .stream()
            .reduce(Number::sum)
            .orElse(Number.zero());
  }

  public static List<Number> positiveNumberList(NumberString numberString, Delimiter delimiter) {
    return Arrays.stream(numberString.getNumberString().split(delimiter.getDelimiter()))
            .map(Number::positiveValueOf)
            .collect(Collectors.toList());
  }
}
