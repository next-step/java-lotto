package step1;

import step1.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
  private static final String PATTERN_MATCHER = "//(.)\n(.*)";
  private static final String COLON_MATCHER = ",|:";

  private static final int DELIMITER_MATCHER = 1;
  private static final int NUMBER_MATCHER = 2;

  private static final Pattern pattern = Pattern.compile(PATTERN_MATCHER);

  private Splitter() {
  }

  public static List<Number> split(String expression) {
    if (expression == null || expression.trim().isEmpty()) {
      return splitNullOrEmpty();
    }

    if (expression.trim().length() == 1) {
      return splitOneObject(expression);
    }

    return splitNumbers(expression);
  }

  private static List<Number> splitNullOrEmpty() {
    List<Number> numbers = new ArrayList<>();
    numbers.add(new Number(0));
    return numbers;
  }

  private static List<Number> splitOneObject(String expression) {
    List<Number> numbers = new ArrayList<>();
    int number = 0;
    try {
      number = Integer.parseInt(expression);
    } catch (Exception e) {
      throw new RuntimeException("해당 수식은 수가 아닙니다.");
    }
    numbers.add(new Number(number));
    return numbers;
  }

  private static List<Number> splitNumbers(String expression) {
    List<Number> numbers = new ArrayList<>();
    String[] tokens = customPatternMatcher(expression);
    for (String token : tokens) {
      int number = Integer.parseInt(token);
      numbers.add(new Number(number));
    }
    return numbers;
  }

  private static String[] customPatternMatcher(String expression) {
    Matcher m = pattern.matcher(expression);
    String[] tokens;
    if (m.find()) {
      String customDelimiter = m.group(DELIMITER_MATCHER);
      tokens = m.group(NUMBER_MATCHER).split(customDelimiter);
      return tokens;
    }

    tokens = expression.split(COLON_MATCHER);
    return tokens;
  }

}
