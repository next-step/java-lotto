package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 연산자() {
        Number leftOperand = Number.from(100);
        Number rightOperand = Number.from(20);

        // 더하기
        assertThat(leftOperand.add(rightOperand)).isEqualTo(Number.from(120));

        // 나누기
        assertThat(leftOperand.divide(rightOperand)).isEqualTo(Number.from(5));

        // 곱하기
        assertThat(leftOperand.multiply(rightOperand)).isEqualTo(Number.from(2_000));

        // 빼기
        assertThat(leftOperand.minus(rightOperand)).isEqualTo(Number.from(80));
    }
}