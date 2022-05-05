package calculator.v2;

import java.util.regex.Pattern;

public class Operand extends Token {

  private static final String REGEX = "[0-9]+";
  private static final Pattern PATTERN = Pattern.compile(String.format("^(%s)", REGEX));
  private static final int OPERAND_PRIORITY = 1;

  public Operand(String input) {
    super(input, PATTERN);
    updateTokenPriority(OPERAND_PRIORITY);
  }

  public static boolean isMatched(String s) {
    return Token.isMatched(PATTERN, s);
  }

  public int getValue() {
    return Integer.parseInt(token);
  }
}
