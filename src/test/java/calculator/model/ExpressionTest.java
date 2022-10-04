package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ExpressionTest {

    @DisplayName("입력 값이 공백이면 에러를 반환한다.")
    @Test
    void validateExpressionIsEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Expression("");
                });
    }

    @DisplayName("입력 값이 null이면 에러를 반환한다.")
    @Test
    void validateExpressionIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Expression(null);
                });
    }

    @DisplayName("입력 값이 숫자가 아니면 에러를 반환한다.")
    @Test
    void validateExpressionNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Expression("a");
                });
    }
}