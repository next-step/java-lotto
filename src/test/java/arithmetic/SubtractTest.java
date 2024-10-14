package arithmetic;

import org.junit.jupiter.api.Test;
import service.Arithmetic.Subtract;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SubtractTest {

    @Test
    public void 빼기 () {
        Subtract subtract = new Subtract();
        assertThat(subtract.calculate(5,2)).isEqualTo(3);
    }
}
