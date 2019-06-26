package step1;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    void numbers_total_sum() {
        Numbers numbers = Numbers.create(List.of("1", "2", "3"));
        assertThat(numbers.getTotalSum()).isEqualTo(6);
    }

}
