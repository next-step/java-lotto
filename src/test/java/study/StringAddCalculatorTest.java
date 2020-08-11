package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    void calculate() {
        StringAddCalculator calculator = new StringAddCalculator("1:1,1");

        int result = calculator.calculate();

        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void calculate_emptyExpression(String empty) {
        StringAddCalculator calculator = new StringAddCalculator(empty);

        int result = calculator.calculate();

        assertThat(result).isZero();
    }
}
