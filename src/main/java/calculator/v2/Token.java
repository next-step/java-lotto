package calculator.v2;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token implements Comparable<Token> {

  private static final String EMPTY_OR_NULL = "빈 값일 수 없습니다.";
  private static final int DEFAULT_PRIORITY = 0;

  private int priority = DEFAULT_PRIORITY;
  private final String token;
  private final Pattern pattern;

  protected Token(String token, Pattern pattern) {
    checkValidToken(token);
    checkValidRegex(pattern);
    this.pattern = pattern;
    checkTokenFormat(token);
    this.token = token;
  }

  protected void updateTokenPriority(int priority) {
    this.priority = priority;
  }

  private void checkValidRegex(Pattern regex) {
    if (regex == null) {
      throw new IllegalArgumentException(EMPTY_OR_NULL);
    }
  }

  private void checkTokenFormat(String token) {
    Matcher m = this.pattern.matcher(token);
    if (!m.find()) {
      throw new IllegalArgumentException(String.format("%s : Token 형식이 일치하지 않습니다.", token));
    }
  }

  private void checkValidToken(String token) {
    if (token == null || token.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_OR_NULL);
    }
  }

  @Override
  public int compareTo(Token o) {
    return this.priority - o.priority;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token1 = (Token) o;
    return token.equals(token1.token) && pattern.equals(token1.pattern);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, pattern);
  }

  @Override
  public String toString() {
    return "Token{" +
        "token='" + token + '\'' +
        '}';
  }
}
