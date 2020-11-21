import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestOperand {
    @Test
    void createWithValidOperand() {
        Operand operand = new Operand("0");
        assertThat(operand).isEqualTo(new Operand("0"));
    }

    @Test
    void createWithInvalidOperandAndOccurredRuntimeException() {
        assertThatThrownBy(() -> {
            Operand operand = new Operand("-1");
        }).isInstanceOf(RuntimeException.class);
    }
}
