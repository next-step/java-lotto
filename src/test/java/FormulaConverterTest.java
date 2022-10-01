import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormulaConverterTest {

    @Test
    @DisplayName("영어면 예외를 던진다.")
    public void validate_input_alphabetic() {
        assertThatThrownBy(() -> FormulaConverter.convert("1a b c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("영어는 들어올 수 없습니다.");
    }

    @Test
    @DisplayName("연산자가 아니면 예외를 던진다.")
    public void validate_input_not_operator() {
        assertThatThrownBy(() -> FormulaConverter.convert("1 = 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자가 아닙니다.");
    }

    @Test
    @DisplayName("입력값이 빈값이면 예외를 던진다.")
    public void validate_input_is_empty() {
        assertThatThrownBy(() -> FormulaConverter.convert(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 없습니다.");
        assertThatThrownBy(() -> FormulaConverter.convert(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 없습니다.");
    }

    @Test
    @DisplayName("수식이 옳지 않으면 예외를 던진다.")
    public void validate_formula() {
        assertThatThrownBy(() -> FormulaConverter.convert("1 - -"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수식이 알맞지 않습니다.");
        assertThatThrownBy(() -> FormulaConverter.convert("1 12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수식이 알맞지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 2 + 2:5", "3:1"}, delimiter = ':')
    @DisplayName("문자열을 나눈다.")
    public void split_string(String input, int size) {
        Queue<String> result = FormulaConverter.convert(input);
        assertThat(result.size()).isEqualTo(size);
    }
}
