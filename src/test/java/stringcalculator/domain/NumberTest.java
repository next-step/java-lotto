package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.exception.DividedByZeroException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    @DisplayName("두 수의 덧셈 결과 반환")
    void addTest() {
        // given
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        // when
        Number result = number1.add(number2);
        // then
        assertThat(result).isEqualTo(new Number(3));
    }

    @Test
    @DisplayName("두 수의 뺄셈 결과를 반환")
    void subtractTest() {
        //given
        Number number1 = new Number(3);
        Number number2 = new Number(2);

        //when
        Number result = number1.minus(number2);

        //then
        assertThat(result).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("두 수의 곱셈 결과를 반환")
    void multiplyTest() {
        //given
        Number number1 = new Number(3);
        Number number2 = new Number(2);

        //when
        Number result = number1.multiply(number2);

        //then
        assertThat(result).isEqualTo(new Number(6));
    }

    @Test
    @DisplayName("두 수의 나눗셈 결과를 반환")
    void divideTest() {
        //given
        Number number1 = new Number(4);
        Number number2 = new Number(2);

        //when
        Number result = number1.divide(number2);

        //then
        assertThat(result).isEqualTo(new Number(2));
    }

    @Test
    @DisplayName("0으로 나눌 경우 DividedByZeroException 발생")
    void divideByZeroTest() {
        //given
        Number number1 = new Number(4);
        Number number2 = new Number(0);

        //when, then
        assertThatThrownBy(() -> number1.divide(number2))
                .isInstanceOf(DividedByZeroException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}