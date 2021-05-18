package stringadder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterOperator {

  private static final Pattern PREFIX_PATTERN = Pattern.compile("//(.)\\\\n");
  private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
  private static final String EMPTY_STRING = "";

  private final List<Number> inputNumbers;

  private CustomDelimiterOperator(String input) {
    String necessaryPart = PREFIX_PATTERN.matcher(input)
                                        .replaceAll(EMPTY_STRING);
    this.inputNumbers = toNumbers(necessaryPart);
  }

  static CustomDelimiterOperator makeCustomDelimiterOperatorFromOperatorSelector(String input) {
    return new CustomDelimiterOperator(input);
  }

  private List<Number> toNumbers(String input) {
    Matcher numberPatternMatcher = NUMBER_PATTERN.matcher(input);
    List<Number> returnNumbers = new ArrayList<>();
    while (numberPatternMatcher.find()) {
      returnNumbers.add(new Number(numberPatternMatcher.group()));
    }
    return returnNumbers;
  }

  public Number sum() {
    return inputNumbers.stream()
                      .reduce(Number.ZERO_NUMBER, Number::sum);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomDelimiterOperator that = (CustomDelimiterOperator) o;
    return inputNumbers.equals(that.inputNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputNumbers);
  }
}
