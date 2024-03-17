package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void 값을_받으면_덧셈을_한다() {
        int result = calculator.add(3,5);

        assertThat(result).isEqualTo(8);
    }

    @Test
    public void 값을_받으면_뺄셈을_한다() {
        int result = calculator.subtract(5,3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 값을_받으면_곱셈을_한다() {
        int result = calculator.multiply(3,5);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 값을_받으면_나눗셈을_한다() {
        int result = calculator.divide(10,2);

        assertThat(result).isEqualTo(5);
    }

}
