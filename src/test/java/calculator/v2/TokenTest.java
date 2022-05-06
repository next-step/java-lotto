package calculator.v2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("토큰 테스트")
public class TokenTest {

  @DisplayName("피연산자 토큰은 0,1,2,3,4,5,6,7,8,9 이다.")
  @ParameterizedTest
  @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
  void operandToken(String input) {
    assertThatNoException().isThrownBy(() -> new Operand(input));
  }

  @DisplayName("피연산자 토큰은 0,1,2,3,4,5,6,7,8,9 이 아니면 예외를 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"-1", "a", "❌"})
  void operandTokenException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Operand(input));
  }

  @DisplayName("숫자토큰은 빈 값이거나 null이면 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void operandTokenNullOrEmptyException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Operand(input));
  }

  @DisplayName("연산자토큰은 사칙 연산자여야 한다.")
  @ParameterizedTest
  @ValueSource(strings = {"+", "-", "*", "/"})
  void operatorToken(String input) {
    assertThatNoException().isThrownBy(() -> new Operator(input));
  }

  @DisplayName("연산자토큰은 사칙 연산자가 아니면 예외를 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"`", "@", "!", "😱", "#", "%", "^", "&", "(", ")"})
  void operatorTokenException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Operator(input));
  }

  @DisplayName("연산자토큰은 빈 값이거나 null이면 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void operatorTokenNullOrEmptyException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Operator(input));
  }

  @DisplayName("공백토큰은 공백으로만 이루어진 값이어야 한다")
  @ParameterizedTest
  @ValueSource(strings = {" ", "  ", "   "})
  void whitespaceToken(String input) {
    assertThatNoException().isThrownBy(() -> new Whitespace(input));
  }

  @DisplayName("공백토큰은 공백으로만 이루어진 값이 아니면 예외를 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"d", "⚠️"})
  void whitespaceTokenException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Whitespace(input));
  }

  @DisplayName("공백토큰은 빈 값 또는 null 이면 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void whitespaceTokenNullOrEmptyException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Whitespace(input));
  }
}
