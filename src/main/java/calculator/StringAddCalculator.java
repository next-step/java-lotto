package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class StringAddCalculator {

  private static final int ZERO = 0;
  private static final int ONE = 1;
  private static final int TWO = 2;
  private static final String CUSTOM_REGEX = "//(.)\n(.*)";
  private static final String DEFAULT_REGEX = ",|:";

  public static int splitAndSum(String text) {
    if (text == null || text.isEmpty()) {
      return ZERO;
    }

    Numbers numbers = convertToNumbers(text);

    if (numbers.isSizeEquals(ONE)) {
      return numbers.getValue(ZERO);
    }

    return numbers.continuousSum();
  }

  private static Numbers convertToNumbers(String text) {
    Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);

    if (m.find()) {
      String customDelimiter = m.group(ONE);
      String[] tokens = m.group(TWO).split(customDelimiter);

      return convertStringToNumber(tokens);
    }

    String[] split = text.split(DEFAULT_REGEX);
    return convertStringToNumber(split);
  }

  private static Numbers convertStringToNumber(String[] tokens) {
    return Arrays.stream(tokens)
                 .map(Number::from)
                 .collect(collectingAndThen(toList(), Numbers::new));
  }

}
