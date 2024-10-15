package arithmetic;

import org.junit.jupiter.api.Test;
import service.Arithmetic.Devide;
import service.Arithmetic.Multiply;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DevideTest {

    @Test
    public void 나눗셈() {
        Devide devide = Devide.getInstance();
        assertThat(devide.calculate(4, 2)).isEqualTo(2);
    }
}
