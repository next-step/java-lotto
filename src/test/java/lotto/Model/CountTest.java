package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CountTest {
    @Test
    @DisplayName("1000원보다 적은 단위 포함하여 입력 시 return error")
    public void count_with_amount_unit_under_1000() {
        int actual = 14100;

        assertThatThrownBy(() -> new Count(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("count 정상 리턴")
    public void count_14000() {
        int expected = 14;

        int input = 14000;
        Count count = new Count(input);
        int actual = count.value();

        assertThat(actual).isEqualTo(expected);
    }
}