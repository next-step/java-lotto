package arithmetic;

import org.junit.jupiter.api.Test;
import service.arithmetic.Divide;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DivideTest {

    @Test
    public void 나눗셈() {
        Divide divide = Divide.getInstance();
        assertThat(divide.calculate(4, 2)).isEqualTo(2);
    }
}
