import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
    @Test
    void addTest() {
        final Numbers numbers = new Numbers(Arrays.asList("1","2","3"));
        final Number actual = numbers.add();
        final Number expected = new Number(6);
        assertThat(actual).isEqualTo(expected);
    }
}