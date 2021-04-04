package calculator;

import calculator.util.StringUtil;

public class StringAdditionCalculator {
  private final Delimiter delimiter;
  private final NumberString numberString;

  private StringAdditionCalculator(Delimiter delimiter, NumberString numberString) {
    this.delimiter = delimiter;
    this.numberString = numberString;
  }

  public static StringAdditionCalculator create(String inputValue) {
    final String blankSafeString = StringUtil.defaultBlankString(inputValue, "0");
    final Delimiter delimiter = Delimiter.createDelimiterRegexString(blankSafeString);
    final NumberString numberString = NumberString.generateNumberString(blankSafeString);
    return new StringAdditionCalculator(delimiter, numberString);
  }

  public Number sum() {
    return PositiveNumbers.generate(delimiter, numberString)
            .sum();
  }
}
