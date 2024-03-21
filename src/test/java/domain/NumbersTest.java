package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("식에서 숫자만 list에 넣는다.")
    void create_Numbers_test() {
        Numbers numbers = Numbers.create(new String[]{"1", "+", "3", "-", "4"});
        assertThat(numbers.getNumbers().contains(Double.parseDouble("1"))).isTrue();
        assertThat(numbers.getNumbers().contains(Double.parseDouble("3"))).isTrue();
        assertThat(numbers.getNumbers().contains(Double.parseDouble("4"))).isTrue();
        assertThat(numbers.getNumbers().contains("+")).isFalse();
        assertThat(numbers.getNumbers().contains("-")).isFalse();
    }

}
