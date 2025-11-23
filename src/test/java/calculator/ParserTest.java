package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParserTest {

    @DisplayName("문자열을 공백 기준 분리한다")
    @Test
    void splitBySpace() {
        assertThat(Parser.parse("1 + 2")).containsExactly("1", "+", "2");
    }

    @DisplayName("문자열에서 연속 공백을 무시하고 분리한다")
    @Test
    void splitByMultipleSpaces() {
        assertThat(Parser.parse("1  +   2")).containsExactly("1", "+", "2");
    }

    @DisplayName("숫자-연산자 순서가 올바른 경우 토큰 배열 반환한다")
    @Test
    void parseValidSequence() {
        String input = "1 + 2 - 3";
        String[] tokens = Parser.parse(input);
        assertThat(tokens).containsExactly("1", "+", "2", "-", "3");
    }

    @DisplayName("숫자-연산자 순서가 잘못된 경우 예외 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1 + + 2", " + 2", "1 +", "- /", "0 1"})
    void parseInvalidSequenceThrows(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parse(input))
                .withMessageContaining("순서");
    }
}