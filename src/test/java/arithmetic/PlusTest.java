package arithmetic;

import org.junit.jupiter.api.Test;
import service.Arithmetic.Multiply;
import service.Arithmetic.Plus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlusTest {

    @Test
    public void 덧셈() {
        Plus plus = new Plus();
        assertThat(plus.calculate(5, 5)).isEqualTo(10);
    }
}
