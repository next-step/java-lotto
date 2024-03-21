package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("식에서 숫자만 list에 넣는다.")
    void create_Numbers_test() {
        Numbers numbers = Numbers.create(new String[]{"1", "+", "3", "-", "4"});
        assertThat(numbers.of(0)).isEqualTo(1);
        assertThat(numbers.of(1)).isEqualTo(3);
        assertThat(numbers.of(2)).isEqualTo(4);
    }

}
