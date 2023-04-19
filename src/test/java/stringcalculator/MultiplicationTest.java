package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    @Test
    void 곱셈() {
        Multiplication multiplication = new Multiplication();
        assertThat(multiplication.apply(2, 4))
            .isEqualTo(8);
    }
}