package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    void shouldReturnIfSingleInput() {
        Numbers numbers = new Numbers("1");
        assertThat(numbers.getNumbers()).contains(new Number(1));
    }

}