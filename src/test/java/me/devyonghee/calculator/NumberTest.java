package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("정수 숫자")
class NumberTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Number.from("1"));
    }

    @ParameterizedTest
    @DisplayName("반드시 숫자 형태의 값")
    @ValueSource(strings = {"", "abc"})
    void instance_invalidNumberFormat_thrownIllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.from(value));
    }

    @Test
    @DisplayName("문자열로 주어진 정수 값 그대로 반환")
    void value() {
        assertThat(Number.from("1").value()).isOne();
    }

    @Test
    @DisplayName("더하기")
    void plus() {
        assertThat(Number.ONE.plus(Number.ONE)).isEqualTo(Number.from("2"));
    }

    @Test
    @DisplayName("빼기")
    void minus() {
        assertThat(Number.ONE.minus(Number.ONE)).isEqualTo(Number.ZERO);
    }

    @Test
    @DisplayName("나누기")
    void multiply() {
        assertThat(Number.ONE.multiply(Number.ZERO)).isEqualTo(Number.ZERO);
        assertThat(Number.ONE.multiply(Number.ONE)).isEqualTo(Number.ONE);
    }

    @Test
    @DisplayName("나누기")
    void divide() {
        assertThat(Number.ONE.divide(Number.ONE)).isEqualTo(Number.ONE);
        assertThat(Number.ZERO.divide(Number.ONE)).isEqualTo(Number.ZERO);
    }

    @Test
    @DisplayName("0으로 나눌 수 없음")
    void divide_zero_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.ONE.divide(Number.ZERO));
    }
}
