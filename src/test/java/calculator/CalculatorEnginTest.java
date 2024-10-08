package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorEnginTest {
    @Test
    void add() {

        Assertions.assertThat(CalculatorEngin.add(new Operand("2"), new Operand("1"))).isEqualTo(3);
    }

    @Test
    void subtract() {

        Assertions.assertThat(CalculatorEngin.subtract(new Operand("2"), new Operand("1"))).isEqualTo(1);
    }

    @Test
    void multiply() {

        Assertions.assertThat(CalculatorEngin.multiply(new Operand("2"), new Operand("3"))).isEqualTo(6);
    }

    @Test
    void divide() {
        Assertions.assertThat(CalculatorEngin.divide(new Operand("3"), new Operand("2"))).isEqualTo(1);
    }

}
