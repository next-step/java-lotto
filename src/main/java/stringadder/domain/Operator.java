package stringadder.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum Operator {
  CUSTOM_DELIMITER(Pattern.compile("//(.)\\\\n(\\d+\\1)*\\d+")),
  DEFAULT_DELIMITER(Pattern.compile("(\\d+[,:])+\\d+"));

  private static final String INVALID_FORMAT_INPUT = "잘못 된 형태의 입력입니다.";

  private final Pattern matchSelector;

  Operator(Pattern matchSelector) {
    this.matchSelector = matchSelector;
  }

  public static Operator selectOperator(String input) {
    return Arrays.stream(values())
            .filter(operator -> isInputMatched(operator.matchSelector, input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_FORMAT_INPUT));
  }

  private static boolean isInputMatched(Pattern pattern, String input) {
    return pattern.matcher(input)
            .matches();
  }
}
