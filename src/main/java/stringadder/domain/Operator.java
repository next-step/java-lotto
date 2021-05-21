package stringadder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static stringadder.domain.Number.fromString;

public enum Operator implements Adder {
  CUSTOM_DELIMITER(Operator::isMatchingCustomDelimiterFormat,
                    Operator::transformToNumbersCustomDelimiterString),
  DEFAULT_DELIMITER(Operator::isMatchingDefaultDelimiterFormat,
                    Operator::transformToNumbersDefaultDelimiterString);

  private static final String INVALID_FORMAT_INPUT = "잘못 된 형태의 입력입니다.";
  private static final String INVALID_CUSTOM_DELIMITER_STRING_FORMAT = "커스텀 구분자 형태의 문자열이 아닙니다.";
  private static final String INVALID_DEFAULT_DELIMITER_STRING_FORMAT = "기본 구분자 형태의 문자열이 아닙니다.";

  private static final Pattern VALID_CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(\\d+\\1)*\\d+");
  private static final Pattern VALID_DEFAULT_DELIMITER_PATTERN = Pattern.compile("(\\d+[,:])+\\d+");
  private static final Pattern CUSTOM_DELIMITER_PREFIX_PATTERN = Pattern.compile("//(.)\\\\n");
  private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
  private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[,:]");

  private final Predicate<String> matchSelector;
  private final Function<String, List<Number>> numberSeparator;

  Operator(Predicate<String> matchSelector, Function<String, List<Number>> numberSeparator) {
    this.matchSelector = matchSelector;
    this.numberSeparator = numberSeparator;
  }

  public static Operator selectOperator(String input) {
    return Arrays.stream(values())
        .filter(operator -> operator.matchSelector
            .test(input))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(INVALID_FORMAT_INPUT));
  }

  private static boolean isMatchingCustomDelimiterFormat(String input) {
    return VALID_CUSTOM_DELIMITER_PATTERN
        .matcher(input)
        .matches();
  }

  private static List<Number> transformToNumbersCustomDelimiterString(String input) {
    if (!isValidInputFormatForCustomDelimiter(input)) {
      throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_STRING_FORMAT);
    }
    String necessaryPart = stripCustomDelimiterPrefix(input);
    return toNumberCustomDelimiterNecessaryPart(necessaryPart);
  }

  private static boolean isValidInputFormatForCustomDelimiter(String input) {
    return VALID_CUSTOM_DELIMITER_PATTERN.matcher(input)
        .matches();
  }

  private static String stripCustomDelimiterPrefix(String input) {
    return CUSTOM_DELIMITER_PREFIX_PATTERN.matcher(input)
                                          .replaceAll("");
  }

  private static List<Number> toNumberCustomDelimiterNecessaryPart(String necessaryPart) {
    Matcher numberPatternMatcher = NUMBER_PATTERN.matcher(necessaryPart);
    List<Number> returnNumbers = new ArrayList<>();
    while (numberPatternMatcher.find()) {
      returnNumbers.add(fromString(numberPatternMatcher.group()));
    }
    return returnNumbers;
  }

  private static boolean isMatchingDefaultDelimiterFormat(String input) {
    return VALID_DEFAULT_DELIMITER_PATTERN
        .matcher(input)
        .matches();
  }

  private static List<Number> transformToNumbersDefaultDelimiterString(String input) {
    if (!isValidInputFormatForDefaultDelimiter(input)) {
      throw new IllegalArgumentException(INVALID_DEFAULT_DELIMITER_STRING_FORMAT);
    }
    return toNumberDefaultDelimiterNecessaryPart(input);
  }

  private static boolean isValidInputFormatForDefaultDelimiter(String input) {
    return VALID_DEFAULT_DELIMITER_PATTERN.matcher(input)
        .matches();
  }

  private static List<Number> toNumberDefaultDelimiterNecessaryPart(String necessaryPart) {
    return Arrays.stream(DEFAULT_DELIMITER_PATTERN
                .split(necessaryPart))
                .map(Number::fromString)
                .collect(Collectors.toList());
  }

  @Override
  public Number add(String input) {
    return numberSeparator.apply(input)
            .stream()
            .reduce(Number.ZERO_NUMBER, Number::sum);
  }
}
