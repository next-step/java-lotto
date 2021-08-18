package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  private final static char BASIC_SPLITTER_COMMA = ',';
  private final static char BASIC_SPLITTER_COLON = ':';
  private final static char OR_OPERATOR_SYMBOL = '|';
  private static final String NUMBER_REGEXP = "^[0-9]+$";
  private static final String CUSTOM_SPLITTER = "//(.)\n(.*)";
  private static final Pattern CUSTOM_SPLITTER_PATTERN = Pattern.compile(CUSTOM_SPLITTER);

  int calculate(String expr, Operator operator) {
    int result = 0;

    String[] splittedExpr = split(expr);

    for (String number : splittedExpr) {
      checkNumberRange(number);
      result = operator.calculate(result, Integer.parseInt(number));
    }

    return result;
  }

  private String[] split(String expr) {

    Matcher m = CUSTOM_SPLITTER_PATTERN.matcher(expr);
    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }

    return expr.split("" + BASIC_SPLITTER_COMMA + OR_OPERATOR_SYMBOL + BASIC_SPLITTER_COLON);
  }

  private void checkNumberRange(String number) {
    if (!number.matches(NUMBER_REGEXP)) {
      throw new RuntimeException("숫자 이외의 값 또는 음수가 있습니다.");
    }
  }
}
