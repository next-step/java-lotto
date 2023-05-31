package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumbersTest {

    Numbers numbers;

    @BeforeEach
    public void init() {
        numbers = new Numbers(new String[]{"1", "2", "3"});
    }

    @Test
    void getNumbersTest() {
        assertThat(numbers.getNumbers())
                .isEqualTo(List.of(new Number(1), new Number(2), new Number(3)));
    }
}