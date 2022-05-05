package calculator.v2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구문 분석기 테스트")
public class SyntaxAnalyzerTest {

  @DisplayName("피연산자가 먼저오고 중간 표현이 없거나 반복해서 올 수 있다.")
  @ParameterizedTest
  @ValueSource(strings = {"1", "1 * 2"})
  void syntax(String input) {
    List<Token> tokens = Lexer.lex(input);
    assertThatNoException().isThrownBy(() -> SyntaxAnalyzer.analyze(tokens));
  }

  @DisplayName("중간 표현은 연산자와 피연산자가 순서대로 와야한다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 + 2 * 3 / 4", "1 / 2 * 3 - 4"})
  void midExpression(String input) {
    List<Token> tokens = Lexer.lex(input);
    assertThatNoException().isThrownBy(() -> SyntaxAnalyzer.analyze(tokens));
  }

  @DisplayName("토큰 개수가 null 이거나 빈 목록이면 예외를 던진다.")
  @ParameterizedTest
  @NullAndEmptySource
  void tokenSizeExpression(List<Token> tokens) {
    assertThatIllegalArgumentException().isThrownBy(() -> SyntaxAnalyzer.analyze(tokens));
  }

  @DisplayName("토큰 개수가 홀수가 아니면 예외를 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 +", "1 2", "1 + 1 -", "1 * 1 /"})
  void tokenSizeExpression(String input) {
    List<Token> tokens = Lexer.lex(input);
    assertThatIllegalArgumentException().isThrownBy(() -> SyntaxAnalyzer.analyze(tokens));
  }

  @DisplayName("분석할 수 없는 구문은 구문 분석 예외를 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"+ 2", "1 +", "1 / - 2", "* 4 5"})
  void cantAnalyzeExpression(String input) {
    List<Token> tokens = Lexer.lex(input);
    assertThatIllegalArgumentException().isThrownBy(() -> SyntaxAnalyzer.analyze(tokens));
  }
}
