package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OperandNumberTest {
    @DisplayName("숫자를 전달하면 객체를 생성한다.")
    @Test
    void create() {
        assertThat(new OperandNumber(8)).isEqualTo(new OperandNumber(8));
    }

    @DisplayName("정수 문자열 외 문자열 입력 시 IllegalArgumentException을 발생시킨다.")
    @Test
    void throw_NumberFormatException_when_argument_is_not_number() {
        assertThatThrownBy(() -> OperandNumber.create("-"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("정수(음수, 0, 양수) 형태의 문자열만 입력 가능합니다.");
    }

    @DisplayName("전달하는 두 값을 덧셈하여 반환한다.")
    @Test
    void plus() {
        OperandNumber first = new OperandNumber(-1);
        OperandNumber second = new OperandNumber(1);

        OperandNumber result = first.plus(second);

        assertThat(result).isEqualTo(new OperandNumber(0));
    }

    @DisplayName("전달하는 두 값을 뺄셈하여 반환한다.")
    @Test
    void minus() {
        OperandNumber first = new OperandNumber(-1);
        OperandNumber second = new OperandNumber(1);

        assertThat(first.minus(second)).isEqualTo(new OperandNumber(-2));
    }

    @DisplayName("전달하는 두 값을 곱셈하여 반환한다.")
    @Test
    void multiply() {
        OperandNumber first = new OperandNumber(-1);
        OperandNumber second = new OperandNumber(-1);

        assertThat(first.multiply(second)).isEqualTo(new OperandNumber(1));
    }

    @DisplayName("전달하는 두 값을 나눗셈하여 반환한다.")
    @Test
    void divide() {
        OperandNumber first = new OperandNumber(2);
        OperandNumber second = new OperandNumber(1);

        assertThat(first.divide(second)).isEqualTo(new OperandNumber(2));
    }

    @DisplayName("나눗셈에서 제수가 0이 되면 ArithmeticException을 발생시킨다.")
    @Test
    void throw_ArithmeticException_when_divisor_is_not_zero() {
        OperandNumber first = new OperandNumber(2);
        OperandNumber zero = new OperandNumber(0);

        assertThatThrownBy(() -> first.divide(zero))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("나눗셈 연산은 0으로 나눌 수 없습니다.");
    }

    @DisplayName("객체를 Integer 타입으로 변환한다.")
    @Test
    void toInteger() {
        assertThat(new OperandNumber(-3).getValue()).isEqualTo(-3);
    }
}
