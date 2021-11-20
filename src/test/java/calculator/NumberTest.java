package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    void sum() {
        Number number = new Number(30);

        Number result = number.sum(new Number(60));

        assertThat(result)
                .isEqualTo(new Number(90));
    }
}