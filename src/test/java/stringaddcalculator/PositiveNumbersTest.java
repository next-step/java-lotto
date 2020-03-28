package stringaddcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveNumbersTest {
    @Test
    void sumTest() {
        //given
        PositiveNumbers positiveNumbers =
                new PositiveNumbers(Arrays.asList(new PositiveNumber(1), new PositiveNumber(2), new PositiveNumber(3)));

        //when
        int sum = positiveNumbers.sum();

        //then
        assertThat(sum).isEqualTo(6);
    }
}