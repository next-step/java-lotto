package step1.domain;

import static step1.constans.Message.NOT_FOUND_PATTEN;
import static step1.constans.RxPattern.CUSTOM_DELIMITER_INPUT_FINDER_PATTERN;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import step1.domain.model.Numbers;
import step1.exception.AdderException;

public class CustomOperation implements Operation {

  private final Numbers numbers;

  public CustomOperation(String input) {
    this.numbers = new Numbers(refineInputValue(input), getCustomDelimiter(input));
  }

  private String refineInputValue(String input) {
    return extractSpecificGroup(CUSTOM_DELIMITER_INPUT_FINDER_PATTERN.matcher(input), 2);
  }

  private Pattern getCustomDelimiter(String input) {
    return Pattern.compile(extractSpecificGroup(CUSTOM_DELIMITER_INPUT_FINDER_PATTERN.matcher(input), 1));
  }

  private String extractSpecificGroup(Matcher patternMatcher, int groupNumber) {
    Optional<String> value = Optional.empty();
    while (patternMatcher.find()) {
      value = Optional.of(patternMatcher.group(groupNumber));
    }
    return value.orElseThrow(() -> new AdderException(NOT_FOUND_PATTEN));
  }

  @Override
  public int sum() {
    return numbers.sum().intValue();
  }
}
