package calculator.arithmetic;

import calculator.service.arithmetic.Multiply;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultiplyTest {

    @Test
    public void 곱셈() {
        Multiply multiply = Multiply.getInstance();
        assertThat(multiply.calculate(3, 4)).isEqualTo(12);
    }
}
