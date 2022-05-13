package calculator.operation;

import calculator.domain.operation.Multiplication;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationTest {

    @Test
    void 곱셈_계산() {
        assertThat(new Multiplication(3, 4).getResult()).isEqualTo(12);
    }

    @Test
    void 곱셈_계산_음수_음수() {
        assertThat(new Multiplication(-3, -4).getResult()).isEqualTo(12);
    }

    @Test
    void 곱셈_계산_음수_양수() {
        assertThat(new Multiplication(-3, 4).getResult()).isEqualTo(-12);
    }
}