package me.namuhuchutong.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("로또 숫자는 1~45 사이의 값을 가진다.")
    @Test
    void number_is_should_be_in_range_of_1_to_45() {
        //when, then
        assertThatThrownBy(() -> new Number(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
