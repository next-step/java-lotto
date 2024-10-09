package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("값이 정확하게 더해지는지 확인")
    @ValueSource(strings = {"3 + 5 + 7"})
    void addTest(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculator(input)).isEqualTo(15);
    }
}
