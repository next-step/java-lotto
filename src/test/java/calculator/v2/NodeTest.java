package calculator.v2;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("노드 테스트")
public class NodeTest {

  @DisplayName("노드는 1개의 토큰을 갖는다.")
  @ParameterizedTest
  @MethodSource("provideForNode")
  void nodeHasOnlyOneToken(Token token) {
    assertThatNoException().isThrownBy(() -> new Node(token));
  }

  private static Stream<Arguments> provideForNode() {
    return Stream.of(
        arguments(new Operand("1")),
        arguments(new Operator("*")),
        arguments(new Whitespace(" "))
    );
  }

  @DisplayName("노드는 left, right 노드를 갖을 수 있다.")
  @ParameterizedTest
  @MethodSource("provideForNodeLeftRight")
  void nodeHasLeftRightNodes(Token token, Node left, Node right) {
    assertThatNoException().isThrownBy(() -> new Node(token, left, right));
  }

  private static Stream<Arguments> provideForNodeLeftRight() {
    return Stream.of(
        arguments(new Operand("1"), null, null),
        arguments(new Operand("1"), new Node(new Operator("*")), new Node(new Operand("2")))
    );
  }
}
