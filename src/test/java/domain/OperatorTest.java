package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    void 덧셈() {
        assertThat(Operator.of("+").calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.of("-").calculate(2, 1)).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        assertThat(Operator.of("*").calculate(1, 2)).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        assertThat(Operator.of("/").calculate(2, 1)).isEqualTo(2);
    }

    @Test
    void 나눗셈_제수_0_IllegalArgumentException_발생() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                   Operator.of("/").calculate(2, 0);
                });
    }

    @Test
    void 사칙연산_기호_아닐때_IllegalArgumentException_발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operator.of("&").calculate(1, 2);
                });
    }

    @Test
    void 사칙연산_모두_포함() {

    }
}