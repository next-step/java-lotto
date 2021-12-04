package lotto;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    void createNumbers_with_String() {
        // given
        String numbersInput = "1, 2, 3, 4, 5, 6";

        // when
        Numbers numbers = new Numbers(numbersInput);

        // then
        assertThat(numbers.getNumbers()).isEqualTo(Lists.list(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)
        ));
    }
}