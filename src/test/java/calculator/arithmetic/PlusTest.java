package calculator.arithmetic;

import calculator.service.arithmetic.Plus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlusTest {

    @Test
    public void 덧셈() {
        Plus plus = Plus.getInstance();
        assertThat(plus.calculate(5, 5)).isEqualTo(10);
    }
}
