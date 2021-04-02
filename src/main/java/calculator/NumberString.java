package calculator;

import java.util.Objects;

import static calculator.util.StringUtil.defaultBlankString;
import static calculator.util.StringUtil.findGroup;

public class NumberString {
  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

  private final String numberString;

  public NumberString(String numberString) {
    this.numberString = numberString;
  }

  public static NumberString generateNumberString(String input) {
    String blankSafeString = defaultBlankString(input, "0");
    return new NumberString(defaultBlankString(findGroup(blankSafeString, CUSTOM_DELIMITER_REGEX, 2), blankSafeString));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NumberString that = (NumberString) o;
    return Objects.equals(numberString, that.numberString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberString);
  }
}
