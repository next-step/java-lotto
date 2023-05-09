package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperandTest {
    private Operand operand1;
    private Operand operand2;

    @BeforeEach
    void init() {
        operand1 = new Operand("10");
        operand2 = new Operand("2");
    }

    @Test
    void create_string() {
        Operand operand = new Operand("3");
        assertThat(operand.getOperand()).isEqualTo(3.0);
    }

    @Test
    void invalid_value() {
        assertThatThrownBy(() -> {
            Operand operand = new Operand("*");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void plus() {
        Double result = operand1.plus(operand2);
        assertThat(result).isEqualTo(12.0);
    }

    @Test
    void minus() {
        Double result = operand1.minus(operand2);
        assertThat(result).isEqualTo(8.0);
    }

    @Test
    void multiple() {
        Double result = operand1.multiple(operand2);
        assertThat(result).isEqualTo(20.0);
    }

    @Test
    void divide() {
        Double result = operand1.divide(operand2);
        assertThat(result).isEqualTo(5.0);
    }
}
