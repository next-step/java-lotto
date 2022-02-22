package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,5,3", "1,5:3", "//;\n1;5;3", "//;\n1;5,3"})
    void 계산기_동작_테스트(String expression) {
        // given
        Numbers numbers = new Numbers(expression);
        StringCalculator stringCalculator = StringCalculator.from(numbers);

        // when
        Number result = stringCalculator.calculate();

        // then
        assertThat(result.getValue()).isEqualTo(9);
    }
}
