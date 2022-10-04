package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.text.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperatorTest {

    @Test
    @DisplayName("더하기")
    void add() {
        assertThat(Operator.of("+").calculate(6, 3)).isEqualTo(9);
    }

    @Test
    @DisplayName("빼기")
    void subtract() {
        assertThat(Operator.of("-").calculate(6, 3)).isEqualTo(3);
    }

    @Test
    @DisplayName("곱하기")
    void multiply() {
        assertThat(Operator.of("*").calculate(6, 3)).isEqualTo(18);
    }

    @Test
    @DisplayName("나누기")
    void divide() {
        assertThat(Operator.of("/").calculate(6, 3)).isEqualTo(2);
    }

    @Test
    @DisplayName("0으로 나누면 에러를 반환한다.")
    void divideException() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    Operator.of("/").calculate(6, 0);
                });
    }

    @Test
    @DisplayName("사칙 연산 기호가 아니면 에러를 반환한다.")
    void notOperatorException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operator.of("@").calculate(1, 2);
                });
    }
}