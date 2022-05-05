package calculator.v2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token {

  private static final String EMPTY_OR_NULL = "토큰은 빈 값일 수 없습니다.";
  private final String token;
  private final Pattern regex;

  public Token(String token, String regex) {
    checkValidToken(token);
    this.regex = Pattern.compile(String.format("^(%s)", regex));
    checkTokenFormat(token);
    this.token = token;
  }

  private void checkTokenFormat(String token) {
    Matcher m = this.regex.matcher(token);
    if (!m.find()) {
      throw new IllegalArgumentException(String.format("%s : Token 형식이 일치하지 않습니다.", token));
    }
  }

  private void checkValidToken(String token) {
    if (token == null || token.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_OR_NULL);
    }
  }
}
