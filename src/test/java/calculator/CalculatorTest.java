package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.ErrorMessage.INVALID_INPUT;

public class CalculatorTest {

    @Test
    @DisplayName("입력이 null 이면 IllegalArgumentException 발생시킨다.")
    void input_null_exception() {
        assertThatThrownBy(() -> Calculator.create().run(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력이 빈 문자열 이거나 공백만 있을 경우 IllegalArgumentException 발생시킨다.")
    void input_blank_exception(String input) {
        assertThatThrownBy(() -> Calculator.create().run(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT);
    }
}
