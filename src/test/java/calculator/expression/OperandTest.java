package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class OperandTest {

    @Test
    void 값_꺼내기() {
        Operand operand = new Operand("2");
        assertThat(operand.getValue()).isEqualTo(2);
    }

    @Test
    void 연산_불가() {
        Operand operand = new Operand("2");
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> {
                    operand.operate(1, 2);
                }).withMessageMatching("not supported in Operand");
    }
}
