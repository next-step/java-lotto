package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("받은 값이 숫자가 아닐 경우, Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b"})
    void value_not_number(String num) {
        assertThatThrownBy(() -> new Number(num))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자가 아닙니다.");
    }

    @DisplayName("숫자가 음수일 경우, Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-3"})
    void value_negative(String num) {
        assertThatThrownBy(() -> new Number(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수입니다.");
    }
}
