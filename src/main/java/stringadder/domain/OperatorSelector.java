package stringadder.domain;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;

import static stringadder.domain.CustomDelimiterOperator.makeCustomDelimiterOperatorFromOperatorSelector;
import static stringadder.domain.DefaultDelimiterOperator.makeDefaultDelimiterOperatorFromOperatorSelector;

public enum OperatorSelector {
  CUSTOM_DELIMITER(Pattern.compile("//(.)\\\\n(\\d+\\1)*\\d+"), input -> makeCustomDelimiterOperatorFromOperatorSelector(input).sum()),
  DEFAULT_DELIMITER(Pattern.compile("(\\d+[,:])+\\d+"), input -> makeDefaultDelimiterOperatorFromOperatorSelector(input).sum());

  private static final String INVALID_FORMAT_INPUT = "잘못 된 형태의 입력입니다.";

  private final Pattern matchSelector;
  private final Function<String, Number> calculator;

  OperatorSelector(Pattern matchSelector, Function<String, Number> calculator) {
    this.matchSelector = matchSelector;
    this.calculator = calculator;
  }

  public static OperatorSelector selectOperator(String input) {
    return Arrays.stream(values())
            .filter(operatorSelector -> isInputMatched(operatorSelector.matchSelector, input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_FORMAT_INPUT));
  }

  private static boolean isInputMatched(Pattern pattern, String input) {
    return pattern.matcher(input)
            .matches();
  }

  public Number calculate(String input) {
    return this.calculator.apply(input);
  }
}
