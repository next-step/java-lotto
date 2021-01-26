package calculator.string.domain;

import calculator.string.view.Input;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void findSymbolTest() {
        calculator.inputExpression("//-\n1-2");
        String result = calculator.findSymbol();
        assertThat(result).isEqualTo("-");
    }
}