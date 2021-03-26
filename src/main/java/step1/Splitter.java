package step1;

import step1.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
  private static final String PATTERN_MATCHER = "//(.)\n(.*)";
  private static final String COLON_MATCHER = ",|:";

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
    List<Number> numberList = new ArrayList<>();
    numberList.add(new Number(0));
    return numberList;
  }

  private static List<Number> splitOneObject(String expression) {
    List<Number> numberList = new ArrayList<>();
    int number = Integer.parseInt(expression);
    numberList.add(new Number(number));
    return numberList;
  }

  private static List<Number> splitNumbers(String expression) {
    List<Number> numberList = new ArrayList<>();
    String[] tokens = customPatternMatcher(expression);
    for (String token : tokens) {
      int number = Integer.parseInt(token);
      numberList.add(new Number(number));
    }
    return numberList;
  }

  private static String[] customPatternMatcher(String expression) {
    Matcher m = Pattern.compile(PATTERN_MATCHER).matcher(expression);
    String[] tokens;
    if (m.find()) {
      String customDelimiter = m.group(1);
      tokens = m.group(2).split(customDelimiter);
      return tokens;
    }

    tokens = expression.split(COLON_MATCHER);
    return tokens;
  }

}
