package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

  private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.*)\n(.*)");

  private final Delimiter delimiter;
  private final MyNumbers numbers;

  private Expression(String expression) {
    this(null, expression);
  }

  private Expression(String delimiter, String expression) {
    this.delimiter = Delimiter.from(delimiter);
    this.numbers = MyNumbers.from(this.delimiter.split(expression));
  }

  public static Expression from(String expression) {
    Matcher matcher = CUSTOM_PATTERN.matcher(expression);

    if (matcher.find()) {
      return new Expression(matcher.group(1), matcher.group(2));
    }

    return new Expression(expression);
  }

  public int calculate() {
    return numbers.addAll();
  }
}
