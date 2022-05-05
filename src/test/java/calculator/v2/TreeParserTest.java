package calculator.v2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("TreeParser 테스트")
public class TreeParserTest {

  @DisplayName("Token 컬렉션을 받아 트리를 생성하고 트리의 루트를 반환한다.")
  @ParameterizedTest
  @MethodSource("provideTokensForParse")
  void parse(List<Token> tokens) {
    assertThat(TreeParser.parsing(tokens)).isInstanceOf(Node.class);
    Node parsing = TreeParser.parsing(tokens);
    System.out.println("parsing = " + parsing);
  }

  private static Stream<Arguments> provideTokensForParse() {
    return Stream.of(
        Arguments.of(
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

  @DisplayName("Token 컬렉션이 null 또는 빈갑이면 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void parseNullOrEmptyException(List<Token> tokens) {
    assertThatIllegalArgumentException().isThrownBy(() -> TreeParser.parsing(tokens));
  }
}
