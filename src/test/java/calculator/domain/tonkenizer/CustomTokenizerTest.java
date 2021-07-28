package calculator.domain.tonkenizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("구분자를 자유롭게 커스터마이징 할 수 있는 커스텀 토크나이저 테스트")
class CustomTokenizerTest {

    @DisplayName("input 스트링이 custom이면 isCustomExpression true를 반환한다")
    @Test
    void should_return_true_correct_custom_expression() {
        //arrange
        String input = "//-\n1-2-3";

        //act, assert
        assertTrue(CustomTokenizer.isCustomExpression(input));
    }

    @DisplayName("input 스트링이 custom이 아니면 isCustomExpression은 false를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"/-\n1-2-3", "//-n1-2-3", "//-\1-2-3"})
    void should_return_false_not_correct_custom_expression(String input) {
        //act, assert
        assertFalse(CustomTokenizer.isCustomExpression(input));
    }

    @DisplayName("유효하지 않은 input값이면 RuntimeException 예외를 던진다.")
    @ValueSource(strings = {"123", "1:2,3", "---", "1,2-3", "1,2,3", "1:2:3"})
    @ParameterizedTest
    void should_throw_exception_when_expression_not_valid(String input) {
        //arrange
        CustomTokenizer customTokenizer = new CustomTokenizer();

        //act, assert
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> customTokenizer.split(input));
    }

    @DisplayName("구분자는 //와 \\n 사이에 위치한다.")
    @MethodSource
    @ParameterizedTest
    void can_split(String input, List<String> expectedToken) {
        //arrange
        CustomTokenizer customTokenizer = new CustomTokenizer();

        //act, assert
        assertThat(customTokenizer.split(input)).containsAll(expectedToken);
    }

    private static Stream<Arguments> can_split() {
        return Stream.of(
                Arguments.of("//-\n1-2-3", Arrays.asList("1", "2", "3")),
                Arguments.of("// \n1 2 3", Arrays.asList("1", "2", "3")),
                Arguments.of("//=\n1=2=3", Arrays.asList("1", "2", "3"))
        );
    }
}