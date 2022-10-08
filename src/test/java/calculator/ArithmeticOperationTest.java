package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArithmeticOperationTest {
    @Test
    void PLUS_부호_변환() {
        assertThat(ArithmeticOperation.sign("+")).isInstanceOf(Plus.class);
    }

    @Test
    void MINUS_부호_변환() {
        assertThat(ArithmeticOperation.sign("-")).isInstanceOf(Minus.class);
    }

    @Test
    void MULTI_부호_변환() {
        assertThat(ArithmeticOperation.sign("*")).isInstanceOf(Multiplication.class);
    }

    @Test
    void DIVIDE_부호_변환() {
        assertThat(ArithmeticOperation.sign("/")).isInstanceOf(Divide.class);
    }

    @Test
    void 사칙연산부호가_아님() {
        assertThatThrownBy(() -> {
                ArithmeticOperation.sign(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
