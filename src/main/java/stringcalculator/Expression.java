package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Expression {

  private static final String DELIMITER = "[,:]";

  private final String expression;

  public Expression(String expression) {
    if (expression == null || expression.isEmpty()) {
      expression = "0";
    }
    this.expression = expression;
  }

  public String[] numbers() {
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
    if (matcher.find()) {
      String customDelimiter = "\\" + matcher.group(1);
      return matcher.group(2).split(customDelimiter);
    }
    return expression.split(DELIMITER);
  }
}
