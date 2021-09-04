package step1;

import org.junit.jupiter.api.Test;
import step1.Number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    @Test
    void createNonNumberValue() {
        assertThrows(NumberFormatException.class, () -> new Number(";"));
    }

    @Test
    void createNegativeValue() {
        assertThrows(NumberFormatException.class, () -> new Number("-1"));
    }

    @Test
    void addTest() {
        Number first = new Number(1);
        Number second = new Number(2);
        Number expected = new Number(1 + 2);

        assertThat(first.add(second)).isEqualTo(expected);
    }
}