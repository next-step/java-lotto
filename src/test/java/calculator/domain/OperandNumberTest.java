package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperandNumberTest {
    @DisplayName("숫자를 전달하면 객체를 생성한다.")
    @Test
    void create() {
        assertThat(new OperandNumber("8")).isEqualTo(new OperandNumber(8));
    }

    @DisplayName("전달하는 두 값을 덧셈하여 반환한다.")
    @Test
    void plus() {
        OperandNumber first = new OperandNumber("-1");
        OperandNumber second = new OperandNumber("1");

        assertThat(first.plus(second)).isEqualTo(new OperandNumber("0"));
    }

    @DisplayName("전달하는 두 값을 뺄셈하여 반환한다.")
    @Test
    void minus() {
        OperandNumber first = new OperandNumber("-1");
        OperandNumber second = new OperandNumber("1");

        assertThat(first.minus(second)).isEqualTo(new OperandNumber("-2"));
    }

    @DisplayName("전달하는 두 값을 곱셈하여 반환한다.")
    @Test
    void multiply() {
        OperandNumber first = new OperandNumber("-1");
        OperandNumber second = new OperandNumber("-1");

        assertThat(first.multiply(second)).isEqualTo(new OperandNumber("1"));
    }

    @DisplayName("전달하는 두 값을 나눗셈하여 반환한다.")
    @Test
    void divide() {
        OperandNumber first = new OperandNumber("2");
        OperandNumber second = new OperandNumber("1");

        assertThat(first.divide(second)).isEqualTo(new OperandNumber("2"));
    }

    @DisplayName("객체를 Integer 타입으로 변환한다.")
    @Test
    void toInteger() {
        assertThat(new OperandNumber("-3").toInteger()).isEqualTo(-3);
    }
}