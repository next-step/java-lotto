package calculator.v2;

public class TokenFactory {

  private static final String NOT_SUPPORT_TOKEN_FORMAT = "[%s] : 지원하지 않는 토큰 형식입니다.";
  private static final String EMPTY_TOKEN = "빈 문자열은 토큰을 생성할 수 없습닌다.";

  private TokenFactory() {
  }

  public static Token createToken(String s) {
    if (s == null || s.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_TOKEN);
    }

    if (Operand.isMatched(s)) {
      return new Operand(s);
    }
    if (Operator.isMatched(s)) {
      return new Operator(s);
    }
    if (Whitespace.isMatched(s)) {
      return new Whitespace(s);
    }
    throw new IllegalArgumentException(String.format(NOT_SUPPORT_TOKEN_FORMAT, s));
  }
}
