package Calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void 입력값이_널이거나_비어있는_경우_예외_발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String input = "";
                    new Input(input);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String input = null;
                    new Input(input);
                });
    }

    @Test
    void 덧셈() {
        Addition addition = new Addition();
        assertThat(addition.sum(1, 3)).isEqualTo(4);
    }

    @Test
    void 뺄셈() {
        Subtraction subtraction = new Subtraction();
        assertThat(subtraction.subtract(2, 1)).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        Multiplication multiplication = new Multiplication();
        assertThat(multiplication.multiply(2, 2)).isEqualTo(4);
    }
}