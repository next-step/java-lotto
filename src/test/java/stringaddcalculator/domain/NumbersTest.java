package stringaddcalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    void numbersTest_합() {
        Numbers numbers = Numbers.of("1,2");
        assertThat(numbers.sum()).isEqualTo(3);
    }
}
