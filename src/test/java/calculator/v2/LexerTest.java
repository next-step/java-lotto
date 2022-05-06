package calculator.v2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Lexer 테스트")
public class LexerTest {

  @DisplayName("입력이 `1 * 2 - 3`이면 `1`, `*`, `2`, `-`, `3` 토큰으로 만든다")
  @ParameterizedTest
  @MethodSource("provideForLex")
  void lexer(String input, List<Token> tokens) {
    assertThat(Lexer.lex(input)).hasSize(tokens.size())
        .allMatch(tokens::contains);
  }

  private static Stream<Arguments> provideForLex() {
    return Stream.of(
        Arguments.of("1 * 2 - 3",
            List.of(
                new Operand("1"),
                new Operator("*"),
                new Operand("2"),
                new Operator("-"),
                new Operand("3")
            )
        )
    );
  }

  @DisplayName("수식에 사용할 수 없는 토큰이 포함되어 토큰 형식 예외를 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"1 - 2 @ 3", ""})
  void lexerException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> Lexer.lex(input));
  }
}
