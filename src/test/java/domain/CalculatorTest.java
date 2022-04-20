package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 3, 6", "2 - 3 * 9 / 3, -3"})
    void 계산기_테스트_정상(String input, int expected) {
        Calculator calculator = new Calculator(InputView.convertStringToArray(input));
        assertThat(calculator.calculate()).isEqualTo(expected);
    }
}