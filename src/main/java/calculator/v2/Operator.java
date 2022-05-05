package calculator.v2;

import java.util.regex.Pattern;

public class Operator extends Token {

  private static final String REGEX = "[+\\-\\*\\/]";
  private static final Pattern PATTERN = Pattern.compile(String.format("^(%s)", REGEX));

  public Operator(String input) {
    super(input, PATTERN);
  }

  public static boolean isMatched(String s) {
    if (s == null || s.isEmpty()) {
      throw new IllegalArgumentException("빈 문자열입니다.");
    }
    return PATTERN.matcher(s).find();
  }
}
