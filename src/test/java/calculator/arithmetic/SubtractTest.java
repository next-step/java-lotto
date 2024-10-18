package calculator.arithmetic;

import calculator.service.arithmetic.Subtract;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SubtractTest {

    @Test
    public void 빼기 () {
        Subtract subtract = Subtract.getInstance();
        assertThat(subtract.calculate(5,2)).isEqualTo(3);
    }
}
