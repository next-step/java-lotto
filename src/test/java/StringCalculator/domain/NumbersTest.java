package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void removeTest() {
        Numbers numbers = new Numbers(new ArrayDeque<>(List.of(1, 2, 3)));

        assertThat(numbers.remove()).isEqualTo(1);
        assertThat(numbers.remove()).isEqualTo(2);
        assertThat(numbers.remove()).isEqualTo(3);
    }

    @Test
    void addFirstTest() {
        Numbers numbers = new Numbers(new ArrayDeque<>(List.of(2, 3)));

        numbers.addFirst(1);

        assertThat(numbers.remove()).isEqualTo(1);
    }


}
