package calculcator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void add() {
        assertThat(Operator.ADDITION.apply(1,2)).isEqualTo(3);
    }

    @Test
    void subtract() {
        assertThat(Operator.SUBTRACTION.apply(2,1)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(Operator.MULTIPLICATION.apply(2,3)).isEqualTo(6);
    }

    @Test
    void divide() {
        assertThat(Operator.DIVISION.apply(6,3)).isEqualTo(2);
    }
}