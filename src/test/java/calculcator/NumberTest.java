package calculcator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void 덧셈() {
        Assertions.assertThat(new Number(3).calculate(Operator.ADDITION,2).getNumber()).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        Assertions.assertThat(new Number(3).calculate(Operator.SUBTRACTION,1).getNumber()).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        Assertions.assertThat(new Number(3).calculate(Operator.MULTIPLICATION,3).getNumber()).isEqualTo(9);
    }

    @Test
    void 나눗셈() {
        Assertions.assertThat(new Number(6).calculate(Operator.DIVISION,3).getNumber()).isEqualTo(2);
    }
}