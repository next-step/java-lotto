package stringcaculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 숫자_합_계산() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number("1"));
        numbers.add(new Number("2"));
        Numbers numbers1 = new Numbers(numbers);
        assertThat(numbers1.sum()).isEqualTo(3);
    }
}