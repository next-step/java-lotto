package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestOperand {
    @Test
    void createWithValidOperand() {
        CalculatorOperand calculatorOperand = new CalculatorOperand("0");
        assertThat(calculatorOperand).isEqualTo(new CalculatorOperand("0"));
    }

    @Test
    void createWithInvalidOperandAndOccurredRuntimeException() {
        assertThatThrownBy(() -> {
            CalculatorOperand calculatorOperand = new CalculatorOperand("-1");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void add() {
        CalculatorOperand calculatorOperand = new CalculatorOperand("1");
        assertThat(calculatorOperand.sum(new CalculatorOperand("2"))).isEqualTo(new CalculatorOperand("3"));
    }
}
