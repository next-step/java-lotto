package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @ParameterizedTest(name = "계산기능 / {0} = 결과: {1}")
    @CsvSource({
            "4, 4",
            "4 + 2, 6",
            "2 + 3 * 4 / 2 - 1, 9"
    })
    void calculate(String inputs, int assertResult) {
        // given
        Calculator calculator = new Calculator(Arrays.asList(inputs.split(" ")));

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(assertResult);
    }

    @Test
    @DisplayName("계산실패/ 2+3* / IllegalArgumentException")
    void calculateBlank() {
        // given
        Calculator calculator = new Calculator(Arrays.asList("2", "+", "3", "*"));

        // when then
        assertThatIllegalArgumentException().isThrownBy(calculator::calculate);
    }
}