package calculator.v2;

public class TokenFactory {

  public static final String NOT_SUPPORT_TOKEN_FORMAT = "%s : 지원하지 않는 토큰 형식입니다.";

  private TokenFactory() {
  }

  public static Token createToken(String s) {
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
