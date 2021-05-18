package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorNumbersTest {

    @Test
    void sum() {
        CalculatorNumbers calculatorNumbers = new CalculatorNumbers(
                Arrays.asList(
                        new CalculatorNumber("1"),
                        new CalculatorNumber("2"),
                        new CalculatorNumber("3")
                )
        );

        assertThat(calculatorNumbers.sum())
                .isEqualTo(6);
    }
}