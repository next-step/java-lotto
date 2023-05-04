package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @Test
    void plus() {
        assertThat(Operator.of("+")).isEqualTo(Operator.PLUS);
    }

    @Test
    void minus() {
        assertThat(Operator.of("+")).isEqualTo(Operator.MINUS);
    }

    @Test
    void multiply() {
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY);
    }
    @Test
    void divide() {
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    void exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.of("a"))
                .withMessageContaining("사칙 연산 기호");
    }
}