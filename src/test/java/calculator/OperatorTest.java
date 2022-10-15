package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {
    @Test
    void plus() {
        assertThat(Operator.PLUS.execute(1,2)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(Operator.MINUS.execute(3,2)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(Operator.MULTIPLY.execute(2,3)).isEqualTo(6);
    }

    @Test
    void divide() {
        assertThat(Operator.DIVIDE.execute(8,4)).isEqualTo(2);
    }

    @Test
    void divide_by_0() {
        assertThatThrownBy(() -> Operator.DIVIDE.execute(8,0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
