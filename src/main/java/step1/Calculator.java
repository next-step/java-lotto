package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  final static char BASIC_SPLITTER_COMMA = ',';
  final static char BASIC_SPLITTER_COLON = ':';
  final static char OR_OPERATOR_SYMBOL = '|';
  private static final String NUMBER_REGEXP = "^[0-9]+$";
  private static final String CUSTOM_SPLITTER = "//(.)\n(.*)";
  private static final Pattern CUSTOM_SPLITTER_PATTERN = Pattern.compile(CUSTOM_SPLITTER);

  int calculate(String expr, Operator operator) {
    int result = 0;

    String[] splittedExpr = split(expr);

    for (String s : splittedExpr) {
      result = operator.calculate(result, Integer.parseInt(s));
    }

    return result;
  }

  public String[] split(String expr) {
    Matcher m = CUSTOM_SPLITTER_PATTERN.matcher(expr);
    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }

    return expr.split("" + BASIC_SPLITTER_COMMA + OR_OPERATOR_SYMBOL + BASIC_SPLITTER_COLON);
  }
}
