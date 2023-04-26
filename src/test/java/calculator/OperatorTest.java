package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {

    @Test
    public void add() {
        assertThat(Operator.ADD.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    public void subtract() {
        assertThat(Operator.SUBTRACT.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    public void multiply() {
        assertThat(Operator.MULTIPLY.calculate(1, 2)).isEqualTo(2);
    }

    @Test
    public void divide() {
        assertThat(Operator.DIVIDE.calculate(1, 2)).isEqualTo(0);
    }

}
