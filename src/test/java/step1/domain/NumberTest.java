package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    @DisplayName("생성 테스트")
    void number_ctor_test() {
        assertThatNoException().isThrownBy(() -> new Number("1"));
    }

    @Test
    @DisplayName("더하기 테스트")
    void plus_test() {
        //given
        Number number = new Number(1);

        //when
        Number result = number.plus(new Number(5));

        //then
        assertThat(result).isEqualTo(new Number(6));
    }

    @Test
    @DisplayName("빼기 테스트")
    void minus_test() {
        //given
        Number number = new Number(5);

        //when
        Number result = number.minus(new Number(1));

        //then
        assertThat(result).isEqualTo(new Number(4));
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiple_test() {
        //given
        Number number = new Number(1);

        //when
        Number result = number.multiple(new Number(5));

        //then
        assertThat(result).isEqualTo(new Number(5));
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide_test() {
        //given
        Number number = new Number(4);

        //when
        Number result = number.divide(new Number(2));

        //then
        assertThat(result).isEqualTo(new Number(2));
    }
}