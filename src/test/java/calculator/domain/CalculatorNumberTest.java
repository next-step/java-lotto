package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@DisplayName("CalculatorNumbers 테스트")
class CalculatorNumberTest {

    @Test
    @DisplayName("CalculatorNumber 생성자, 런타임 예외 케이스 테스트")
    void new_예외() {
        // Given
        String input = valueOf(Integer.MIN_VALUE);

        // When, Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CalculatorNumber(input));
    }
}