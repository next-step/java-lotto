package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 3, 6", "2 - 3 * 9 / 3, -3"})
    void 정상_계산기_테스트(String input, int expected) {
        Calculator calculator = new Calculator(InputView.convertStringToArray(input));
        assertThat(calculator.calculate()).isEqualTo(expected);
    }

    @Test
    void 비정상_수식_순서_테스트() {
        assertThatThrownBy(
                () -> {
                    new Calculator(InputView.convertStringToArray("2 + * 3 4 / 2"))
                    .calculate();
                }
        ).isInstanceOf(NumberFormatException.class);
    }
}