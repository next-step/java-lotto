package arithmetic;

import org.junit.jupiter.api.Test;
import service.Arithmetic.Multiply;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultiplyTest {

    @Test
    public void 곱셈() {
        Multiply multiply = Multiply.getInstance();
        assertThat(multiply.calculate(3, 4)).isEqualTo(12);
    }
}
