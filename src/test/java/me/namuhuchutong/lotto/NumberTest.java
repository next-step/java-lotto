package me.namuhuchutong.lotto;

import me.namuhuchutong.lotto.domain.Number;
import org.assertj.core.api.Assertions;
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

    @DisplayName("동일한 숫자는 참을 반환한다.")
    @Test
    void test() {
        //given
        Number number1 = new Number(1);
        Number number2 = new Number(1);

        //then
        Assertions.assertThat(number1.equals(number2)).isTrue();
    }

    @DisplayName("다른 숫자는 거짓을 반환한다.")
    @Test
    void test2() {
        //given
        Number number1 = new Number(1);
        Number number2 = new Number(2);

        //then
        Assertions.assertThat(number1.equals(number2)).isFalse();
    }
}
