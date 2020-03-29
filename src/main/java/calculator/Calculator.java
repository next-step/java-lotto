package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
  private static final String DELIMITER_ESCAPE_FORMAT = "\\%s";
  private static final String DEFAULT_DELIMITER = ",|:";
  private static final Set<String> META_CHARACTER = new HashSet<>(Arrays.asList("+", "*", "^"));

  public static int splitAndSum(String expression) {
    if (expression == null) {
      return 0;
    }

    return parseExpression(expression).sum();
  }

  private static NonNegativeTokens parseExpression(String expression) {
    Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(expression);
    boolean matched = m.find();
    String delimeter = matched ? m.group(1) : DEFAULT_DELIMITER;
    String tokenString = matched ? m.group(2) : expression;

    if (META_CHARACTER.contains(delimeter)) {
      delimeter = String.format(DELIMITER_ESCAPE_FORMAT, delimeter);
    }

    return new NonNegativeTokens(tokenString, delimeter);
  }
}

