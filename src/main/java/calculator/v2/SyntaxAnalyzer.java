package calculator.v2;

import java.util.List;

public class SyntaxAnalyzer {

  private static final int FIRST_TOKEN_INDEX = 0;
  private static final int ANALYZE_START_INDEX = 1;
  private static final int ANALYZE_STEP = 2;

  public static void analyze(List<Token> tokens) {
    validateTokenList(tokens);

    int tokenSize = tokens.size();
    validateTokenSize(tokenSize);

    // <expr> := <operand><mid expr>*
    Token firstToken = tokens.get(FIRST_TOKEN_INDEX);
    if (isNotOperand(firstToken)) {
      throw new IllegalArgumentException(firstToken + " 첫번째 토큰은 피연산자여야 합니다.");
    }

    // <expr> := <operand><mid expr>*
    for (int i = ANALYZE_START_INDEX; i < tokenSize; i += ANALYZE_STEP) {
      Token token = tokens.get(i);
      if (!isNotOperator(token)) {
        throw new IllegalArgumentException(tokens + " 는 연산자가 아닙니다.");
      }
      Token nextToken = tokens.get(i + 1);
      if (isNotOperand(nextToken)) {
        throw new IllegalArgumentException(tokens + " 는 피연산자다 아닙니다.");
      }
    }
  }

  private static void validateTokenList(List<Token> tokens) {
    if (tokens == null || tokens.isEmpty()) {
      throw new IllegalArgumentException("토큰 목록은 빈값일 수 없습니다.");
    }
  }

  private static void validateTokenSize(int tokenSize) {
    if ((tokenSize % 2) == 0) {
      throw new IllegalArgumentException("토큰 개수는 홀수여야 합니다.");
    }
  }

  private static boolean isNotOperator(Token token) {
    return (token instanceof Operator);
  }

  private static boolean isNotOperand(Token token) {
    return !(token instanceof Operand);
  }
}
