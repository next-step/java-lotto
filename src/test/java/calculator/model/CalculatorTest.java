package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("입력 값이 공백이면 에러를 반환한다.")
    @Test
    void validateExpressionIsEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator("");
                });
    }

    @DisplayName("입력 값이 null이면 에러를 반환한다.")
    @Test
    void validateExpressionIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(null);
                });
    }

}