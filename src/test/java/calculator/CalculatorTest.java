package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.tokenizer.SpaceExpressionTokenizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 + 2 / 3:1"}, delimiter = ':')
    public void 연산_테스트(String value, int ouput) {
        Calculator calculator = new Calculator(new ExpressionParser(new SpaceExpressionTokenizer()));

        int result = calculator.calc(value);

        assertThat(result).isEqualTo(ouput);
    }
}
