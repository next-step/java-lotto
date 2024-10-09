package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorEnumTest {
    @Test
    void add() {

        Assertions.assertThat(OperatorEnum.ADD.calculate(new Operand("2"), new Operand("1"))).isEqualTo(3);
    }

    @Test
    void subtract() {

        Assertions.assertThat(OperatorEnum.SUBTRACT.calculate(new Operand("2"), new Operand("1"))).isEqualTo(1);
    }

    @Test
    void multiply() {

        Assertions.assertThat(OperatorEnum.MULTIPLY.calculate(new Operand("2"), new Operand("3"))).isEqualTo(6);
    }

    @Test
    void divide() {
        Assertions.assertThat(OperatorEnum.DIVIDE.calculate(new Operand("3"), new Operand("2"))).isEqualTo(1);
    }

}
