package stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Expression {

  public static final String ZERO_STRING = "0";
  private static final int CUSTOM_DELIMITER_GROUP = 1;
  private static final int EXPRESSION_GROUP = 2;
  private static final String DELIMITER = "[,:]";
  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
  private static final String ESCAPE_CHARACTER = "\\";

  private final String expression;

  public Expression(String expression) {
    if (expression == null || expression.isEmpty()) {
      expression = ZERO_STRING;
    }
    this.expression = expression;
  }

  public String[] numbers() {
    Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
    if (matcher.find()) {
      String customDelimiter = ESCAPE_CHARACTER + matcher.group(CUSTOM_DELIMITER_GROUP);
      return matcher.group(EXPRESSION_GROUP).split(customDelimiter);
    }
    return expression.split(DELIMITER);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Expression)) {
      return false;
    }
    Expression that = (Expression) o;
    return Objects.equals(expression, that.expression);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expression);
  }
}
