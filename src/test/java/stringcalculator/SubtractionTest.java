package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {
    @Test
    void 뺄셈() {
        Subtraction subtraction = new Subtraction();
        assertThat(subtraction.apply(4, 2))
            .isEqualTo(2);
    }
}