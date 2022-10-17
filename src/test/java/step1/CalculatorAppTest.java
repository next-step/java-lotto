package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorAppTest {

    @DisplayName("null이나 빈 문자열 입력 시 에외 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    void inputNullOrBlankTest(String input) {
        assertThatThrownBy(() -> CalculatorApp.validateBlank(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
