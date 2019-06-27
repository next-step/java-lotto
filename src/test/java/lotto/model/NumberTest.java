package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {


    @Test
    @DisplayName("범위를 넘어서 숫자 예외처리")
    public void rangeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Number(46);
            new Number(0);
        });
    }

    @Test
    @DisplayName("숫자 비교")
    public void compare() {
        Number three = new Number(3);
        Number five = new Number(3);
        assertThat(three.compareTo(five)).isEqualTo(0);
    }
}