package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    void shouldBeEqualTo() {
        Number number = new Number(1);
        assertThat(number).isEqualTo(new Number(1));
    }
}