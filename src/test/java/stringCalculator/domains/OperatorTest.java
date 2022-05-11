package stringCalculator.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    @DisplayName("사칙연산자가 아닐 경우 IllegalArgumentException 발생")
    @Test
    void validate() {
        assertThatThrownBy(() -> {
            new Operator("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 + 2 = 3")
    @Test
    void plus() {
        Operator addition = new Operator("+");
        int result = addition.operate(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("1 - 2 = -1")
    @Test
    void minus() {
        Operator subtraction = new Operator("-");
        int result = subtraction.operate(1, 2);

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("1 * 2 = 2")
    @Test
    void multiply() {
        Operator multiplication = new Operator("*");
        int result = multiplication.operate(1, 2);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("10 / 5 = 2")
    @Test
    void divide() {
        Operator division = new Operator("/");
        int result = division.operate(10, 5);

        assertThat(result).isEqualTo(2);
    }
}
