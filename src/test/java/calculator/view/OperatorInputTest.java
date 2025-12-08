package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static calculator.Calculator.calculate;

class OperatorInputTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void exception(
            String input
    ) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.parseInput(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 & 3", "5 % 2", "10 ^ 2"})
    @DisplayName("사칙연산 기호가 아닌 경우")
    void exception2(
            String input
    ) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculate(input.split(" "));
        });
    }
}
