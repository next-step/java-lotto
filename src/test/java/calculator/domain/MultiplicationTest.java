package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    @Test
    void 곱셈() {
        Multiplication multiplication = new Multiplication();

        assertThat(multiplication.calculate(1, 5)).isEqualTo(5);
    }
}