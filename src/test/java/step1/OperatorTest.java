package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Operator;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {
    @Test
    void add() {
        int result = Operator.ADD.calculate(3, 5);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void minus() {
        int result = Operator.MINUS.calculate(3, 5);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    void multiple() {
        int result = Operator.MULTIPLE.calculate(3, 5);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void divide() {
        int result = Operator.DIVIDE.calculate(12, 5);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void divideException() {
        assertThatThrownBy(() -> Operator.DIVIDE.calculate(12, 0))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void notOperator() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.from("%"));
    }
}
