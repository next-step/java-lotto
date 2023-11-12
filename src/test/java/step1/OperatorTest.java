package step1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    public void 덧셈_타입_반환_테스트() {
        Operator operator = Operator.findOperatorByUserInput('+');

        assertThat(operator).isEqualTo(Operator.PLUS);
    }

    @Test
    public void 뺄셈_타입_반환_테스트() {
        Operator operator = Operator.findOperatorByUserInput('-');

        assertThat(operator).isEqualTo(Operator.MINUS);
    }

    @Test
    public void 곱셈_타입_반환_테스트() {
        Operator operator = Operator.findOperatorByUserInput('*');

        assertThat(operator).isEqualTo(Operator.MULTIPLICATION);
    }

    @Test
    public void 나눗셈_타입_반환_테스트() {
        Operator operator = Operator.findOperatorByUserInput('/');

        assertThat(operator).isEqualTo(Operator.DIVISION);
    }
}
