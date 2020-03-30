package stringaddcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @Test
    public void sumTest() {
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 3));
        int result = numbers.sum();
        assertThat(result).isEqualTo(6);
    }
}
