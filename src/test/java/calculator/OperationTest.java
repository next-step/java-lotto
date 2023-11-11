package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
