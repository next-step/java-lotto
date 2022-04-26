package calculator.domain;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @Test
    @DisplayName("공란을 입력할 경우 InvalidInputException 를 반환한다.")
    void blankValidate() {
        assertThatThrownBy(() -> StringCalculator.calculate(" "))
                .isInstanceOf(InvalidInputException.class);
    }

    @Test
    @DisplayName("null 을 입력할 경우 InvalidInputException 를 반환한다.")
    void nullValidate() {
        assertThatThrownBy(() -> StringCalculator.calculate(null))
                .isInstanceOf(InvalidInputException.class);
    }

    @Test
    @DisplayName("'2 + 3 * 4 / 2' 를 입력하면 10을 반환한다.")
    void calculate() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}