package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("로또 숫자는 6개이다")
    @Test
    void lotto_numbers_should_be_six() {
        //when
        Numbers numbers = new Numbers(List.of(1, 1, 1, 1, 1, 1));

        //then
        assertThat(numbers.size()).isEqualTo(6);
    }
    
    @DisplayName("로또 숫자가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_numbers_is_not_six() {
        //when, then
        assertThatThrownBy(() -> new Numbers(List.of(1, 1, 1, 1, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자는 1~45 사이의 값을 가진다.")
    @Test
    void number_is_should_be_in_range_of_1_to_45() {
        //when, then
        assertThatThrownBy(() -> new Numbers(List.of(1, 1, 1, 100, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
