package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperationTest {

    @Test
    void plus() {
        int result = Operation.PLUS.calculate(10, 3);

        assertThat(result).isEqualTo(13);
    }

    @Test
    void minus() {
        int result = Operation.MINUS.calculate(10, 3);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void times() {
        int result = Operation.TIMES.calculate(10, 3);

        assertThat(result).isEqualTo(30);
    }

    @Test
    void division() {
        int result = Operation.DIVISION.calculate(10, 3);

        assertThat(result).isEqualTo(3);
    }
    @DisplayName("0으로 나눗셈 연산을 시도하면 예외가 발생합니다.")
    @Test
    void zero_division() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operation.DIVISION.calculate(10, 0);
        });
    }
}
