package stringadder.domain;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;

public enum Operator {
  CUSTOM_DELIMITER(input -> Pattern.compile("//(.)\\\\n(\\d+\\1)*\\d+")
                                  .matcher(input)
                                  .matches()),
  DEFAULT_DELIMITER(input -> Pattern.compile("(\\d+[,:])+\\d+")
                                    .matcher(input)
                                    .matches());

  private final Function<String, Boolean> matchSelector;

  Operator(Function<String, Boolean> matchSelector) {
    this.matchSelector = matchSelector;
  }

  public static Operator selectOperator(String input) {
    return Arrays.stream(values())
            .filter(operator -> operator.matchSelector.apply(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(""));
  }
}
