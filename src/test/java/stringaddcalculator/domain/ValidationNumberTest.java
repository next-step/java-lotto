package stringaddcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidationNumberTest {

    @ParameterizedTest
    @DisplayName("공백 또는 null이 들어올 경우 True을 리턴")
    @NullAndEmptySource
    void numberIsBlank(String expression) {
        boolean isResult = ValidationNumber.isBlank(expression);
        assertThat(isResult).isTrue();
    }

    @Test
    @DisplayName("음수가 들어올 경우 RuntimeException 발생")
    void numberIsNegativeQuantity() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    ValidationNumber.negativeQuantity(-1);
                });
    }

    @Test
    @DisplayName("계산식에 유효하지 않은 값 들어올 경우 RuntimeException 발생")
    void invalidInputCheck() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    ValidationNumber.invalidInput("a,2,3");
                });
    }

}