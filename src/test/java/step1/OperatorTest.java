package step1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    public void 덧셈_타입_반환_테스트() {

        Operator operator = Operator.findOperatorByUserInput('+');

        assertThat(operator).isEqualTo(Operator.PLUS);
    }
}

