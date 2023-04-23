package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionTest {
    @Test
    void 덧셈() {
        Addition addition = new Addition();
        assertThat(addition.apply(1, 2))
            .isEqualTo(3);
    }
}