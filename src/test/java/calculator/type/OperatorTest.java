package calculator.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {
    @Test
    void add() {
        int result = Operator.ADD.operate(10, 20);

        assertThat(result).isEqualTo(30);
    }

    @Test
    void subtract() {
        int result = Operator.SUBTRACT.operate(20, 10);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void multiply() {
        int result = Operator.MULTIPLY.operate(10, 20);

        assertThat(result).isEqualTo(200);
    }

    @Test
    void divide() {
        int result = Operator.DIVIDE.operate(20, 5);

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("0으로 나누면 예외 발생")
    @Test
    void divideZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.DIVIDE.operate(10, 0));
    }
}
