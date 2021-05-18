package stringadder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DefaultDelimiterOperator {

  private static final Pattern VALID_DEFAULT_DELIMITER_PATTERN = Pattern.compile("(\\d+[,:])+\\d+");
  private static final Pattern DEFAULT_DELIMITER = Pattern.compile("[,:]");
  private static final String INVALID_CUSTOM_DELIMITER_STRING_FORMAT = "기본 구분자 형태의 문자열이 아닙니다.";
  private final List<Number> inputNumbers;

  private DefaultDelimiterOperator(String input) {
    this.inputNumbers = toNumbers(input);
  }

  static DefaultDelimiterOperator makeDefaultDelimiterOperatorFromOperatorSelector(String input) {
    if (!isValidInputFormat(input)) {
      throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_STRING_FORMAT);
    }
    return new DefaultDelimiterOperator(input);
  }

  private static boolean isValidInputFormat(String input) {
    return VALID_DEFAULT_DELIMITER_PATTERN.matcher(input)
                                          .matches();
  }

  private List<Number> toNumbers(String input) {
    return Arrays.stream(DEFAULT_DELIMITER
        .split(input))
        .map(Number::new)
        .collect(Collectors.toList());
  }

  public Number sum() {
    return inputNumbers.stream()
        .reduce(Number.ZERO_NUMBER, Number::sum);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DefaultDelimiterOperator that = (DefaultDelimiterOperator) o;
    return inputNumbers.equals(that.inputNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputNumbers);
  }
}
