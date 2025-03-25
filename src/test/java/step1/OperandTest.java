package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step1.domain.Operand;

class OperandTest {
    @Test
    void notNumException() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Operand.from("f"));
    }
}
