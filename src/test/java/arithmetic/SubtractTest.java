package arithmetic;

import org.junit.jupiter.api.Test;
import service.arithmetic.Subtract;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SubtractTest {

    @Test
    public void 빼기 () {
        Subtract subtract = Subtract.getInstance();
        assertThat(subtract.calculate(5,2)).isEqualTo(3);
    }
}
