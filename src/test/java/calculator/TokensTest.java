package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class TokensTest {

    Tokens tokens;

    @Test
    @DisplayName("Integer 리스트로 변환")
    void name() {

        tokens = new Tokens(Arrays.asList("1", "2", "3"));
        assertThat(tokens.convertToIntegers()).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("Integer 리스트로 변환 시 음수가 있다면 RuntimeException 발생")
    void convertToIntegersContainsNegative() {

        tokens = new Tokens(Arrays.asList("1", "-1", "3"));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> tokens.convertToIntegers());
    }

    @Test
    @DisplayName("Integer 리스트로 변환 시 문자가 있다면 RuntimeException 발생")
    void convertToIntegersContainsWord() {

        tokens = new Tokens(Arrays.asList("1", "word", "3"));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> tokens.convertToIntegers());
    }
}