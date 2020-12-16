package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveNumbersTest {

    @Test
    void sum() {
        PositiveNumber[] values = new PositiveNumber[] {
                new PositiveNumber("1"),
                new PositiveNumber("2")
        };
        PositiveNumbers positiveNumbers = new PositiveNumbers(values);
        int result = positiveNumbers.sum();
        assertThat(result).isEqualTo(3);
    }

}
