package stringadder;

import java.util.regex.Pattern;

import static stringadder.domain.Number.ZERO_NUMBER;
import static stringadder.domain.Number.fromString;
import static stringadder.domain.Operator.selectOperator;

public class StringAdder {

  private static final Pattern SPACE_PATTERN = Pattern.compile("\\s");
  private static final int SINGLE_STRING_LENGTH = 1;

  private StringAdder() {
  }

  public static int calculate(String input) {
    if (isNullOrEmpty(input)) {
      return ZERO_NUMBER.getValue();
    }
    String trimmedInput = removeSpace(input);
    if (isSingleLengthString(trimmedInput)) {
      return fromString(trimmedInput).getValue();
    }
    return selectOperator(trimmedInput).calculate(trimmedInput)
                                        .getValue();
  }

  private static boolean isNullOrEmpty(String input) {
    return input == null || input.trim()
                                  .isEmpty();
  }

  private static boolean isSingleLengthString(String input) {
    return input.length() == SINGLE_STRING_LENGTH;
  }

  private static String removeSpace(String input) {
    return SPACE_PATTERN.matcher(input)
                        .replaceAll("");
  }
}
