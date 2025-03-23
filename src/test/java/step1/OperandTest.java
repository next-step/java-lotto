package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperandTest {

    @Test
    void 피연산자는_정수값을_가진다() {
        Operand operand = new Operand(1);
        assertThat(operand.getValue()).isEqualTo(1);
    }
}
