package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @Test
    @DisplayName("공란을 입력할 경우 IllegalArgumentException 를 반환한다.")
    void blankValidate() {
        assertThatThrownBy(() -> StringCalculator.calculate(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null 을 입력할 경우 IllegalArgumentException 를 반환한다.")
    void nullValidate() {
        assertThatThrownBy(() -> StringCalculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}