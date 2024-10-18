package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.tokenizer.SpaceExpressionTokenizer;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    @Test
    public void 연산_테스트() {
        Calculator calculator = new Calculator(new ExpressionParser(new SpaceExpressionTokenizer()));

        int result = calculator.calc("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }
}
