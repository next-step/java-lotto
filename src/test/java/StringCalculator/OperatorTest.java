package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void calculate() {
        assertThat(Operator.PLUS.calculate(1,2)).isEqualTo(3);
    }

    @Test
    void findOperator() {
        assertThat(Operator.findOperator("1 + 2")).isEqualTo(Operator.PLUS);
    }
}