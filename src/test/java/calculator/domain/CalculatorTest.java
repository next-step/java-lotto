package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import calculator.domain.Number;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,5,3", "1,5:3", "//;\n1;5;3", "//;\n1;5,3"})
    void 계산기_동작_테스트(String expression) {
        // given
        final Numbers numbers = new Numbers(expression);
        final StringCalculator stringCalculator = StringCalculator.from(numbers);

        // when
        final Number result = stringCalculator.calculate();

        // then
        assertThat(result.getNumber()).isEqualTo(9);
    }
}
