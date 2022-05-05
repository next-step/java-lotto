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

  public int apply(int left, int right) {
    return Operator.operate(token, left, right);
  }

  private static int operate(String token, int left, int right) {
    if ("+".equals(token)) {
      return left + right;
    }
    if ("-".equals(token)) {
      return left - right;
    }
    if ("*".equals(token)) {
      return left * right;
    }
    if ("/".equals(token)) {
      validateNumerator(right);
      return left / right;
    }
    return 0;
  }

  private static void validateNumerator(int rvalue) {
    if (rvalue == 0) {
      throw new NumberFormatException("0 으로 나눌 수 없습니다.");
    }
  }
}
