package calculator.v2;

import java.util.regex.Pattern;

public class Whitespace extends Token {

  private static final String REGEX = "[\\s]+";
  private static final Pattern PATTERN = Pattern.compile(String.format("^(%s)", REGEX));

  public Whitespace(String token) {
    super(token, PATTERN);
  }

  public static boolean isMatched(String s) {
    return Token.isMatched(PATTERN, s);
  }
}
