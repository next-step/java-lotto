package calculator.calculate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ArithmeticTest {

    @Test
    void 덧셈() {
        assertThat(Arithmetic.ADD.apply(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(Arithmetic.MINUS.apply(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(Arithmetic.MULTIPLY.apply(1, 2)).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        assertThat(Arithmetic.DIVIDE.apply(2, 1)).isEqualTo(2);
    }

    @Test
    void 나눗셈_0으로_나눌수없음() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Arithmetic.DIVIDE.apply(1, 0);
        });
    }

    @Test
    void 입력한_사칙연산_값으로_추출() {
        assertThat(Arithmetic.fromSymbol("+")).isEqualTo(Arithmetic.ADD);
        assertThat(Arithmetic.fromSymbol("-")).isEqualTo(Arithmetic.MINUS);
        assertThat(Arithmetic.fromSymbol("*")).isEqualTo(Arithmetic.MULTIPLY);
        assertThat(Arithmetic.fromSymbol("/")).isEqualTo(Arithmetic.DIVIDE);
    }

    @Test
    void 사칙연산_값이_아닌경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> Arithmetic.fromSymbol("_"));
    }

}
