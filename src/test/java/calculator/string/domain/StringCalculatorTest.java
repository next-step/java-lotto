package calculator.string.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    public StringCalculator calculator = new StringCalculator();

    @Test
    public void calculationNormalTest() {
        int result;

        calculator.inputExpression("1,2");
        result = calculator.calculation();
        assertThat(result).isEqualTo(3);

        calculator.inputExpression("4,5");
        result = calculator.calculation();
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void mergeSymbolsTest() {
        calculator.inputExpression("1,2");
        String result = calculator.mergeSymbols();
        assertThat(result).isEqualTo(":|,");
    }
}