package step1.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    @DisplayName("숫자 문자열로부터 생성")
    void createWithString() {
        Number number = new Number("123");
        assertThat(number).isEqualTo(new Number("123"));
    }

    @Test
    @DisplayName("숫자 정수로부터 생성")
    void createWithInteger() {
        Number number = new Number(123);
        assertThat(number).isEqualTo(new Number(123));

    }

    @Test
    @DisplayName("입력 타입이 다른 두 숫자 객체 간의 비교")
    void compareTwoNumbers() {
        Number number1 = new Number("123");
        Number number2 = new Number(123);
        Number number3 = new Number(124);

        assertThat(number1).isEqualTo(number2);
        assertThat(number1).isNotEqualTo(number3);
    }

    @Test
    @DisplayName("숫자 이외의 값이 들어왔을 때 예외 반환")
    void createWithInvalidString() {
        assertThatThrownBy(() -> new Number("hello"))
            .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("0으로 나눌 시 예외")
    void divideByZero() {
        assertThatThrownBy(() -> new Number(3).divide(new Number(0)))
            .isInstanceOf(ArithmeticException.class);
    }
}
