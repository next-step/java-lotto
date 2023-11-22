package stringCalculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"4 + 1 * 3"})
    void test_StringToArray(String input) {
        assertThat(Parser.parseInput(input)).hasSize(5);
        assertThat(Parser.parseInput(input)).containsExactly("4", "+", "1", "*", "3");
    }

    @Test
    void exceptionTest_숫자나_기호가_아닌값() {
        assertThatIllegalArgumentException().isThrownBy(() -> Parser.parseInput("a b"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"- 1 + 4", "6 * / 5", "8 /"})
    void exceptionTest_기호가_숫자사이에_위치하지_않음(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Parser.parseInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void exceptionTest_빈값(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Parser.parseInput(input));
    }

}