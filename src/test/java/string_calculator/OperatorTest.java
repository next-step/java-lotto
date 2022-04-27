package string_calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void computeShouldWork() {
        assertThat(Operator.PLUS.compute(new Integer(2),new Integer(1))).isEqualTo(new Integer(3));
        assertThat(Operator.MINUS.compute(new Integer(2),new Integer(1))).isEqualTo(new Integer(1));
        assertThat(Operator.MULTIPLY.compute(new Integer(2),new Integer(1))).isEqualTo(new Integer(2));
        assertThat(Operator.DIVIDE.compute(new Integer(2),new Integer(1))).isEqualTo(new Integer(2));
        assertThat(Operator.MODULO.compute(new Integer(2),new Integer(1))).isEqualTo(new Integer(0));
    }
}
