package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private final StringAddCalculator calculator = new StringAddCalculator();

    @ParameterizedTest
    @NullAndEmptySource
    void calculate_nullAndEmpty(String text) {
        assertThat(calculator.calculate(text)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3"})
    void calculate(String text) {
        assertThat(calculator.calculate(text)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3;4", "//;\n1,2:3;4", "//-\n1-2-3-4"})
    void calculate_custom(String text) {
        assertThat(calculator.calculate(text)).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1,2", "a", "//-\n1--2"})
    void calculateFail(String text) {
        assertThatThrownBy(() -> {
            calculator.calculate(text);
        }).isInstanceOf(RuntimeException.class);
    }
    
}
