package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArithmeticTest {
    @Test
    void 덧셈_가져오기() {
        // given
        String sign = "+";
        // when
        Arithmetic arithmetic = Arithmetic.findSign(sign);
        // then
        assertThat(arithmetic).isEqualTo(Arithmetic.PLUS);
    }

    @Test
    void 뺄셈_가져오기() {
        // given
        String sign = "-";
        // when
        Arithmetic arithmetic = Arithmetic.findSign(sign);
        // then
        assertThat(arithmetic).isEqualTo(Arithmetic.MINUS);
    }

    @Test
    void 곱셈_가져오기() {
        // given
        String sign = "*";
        // when
        Arithmetic arithmetic = Arithmetic.findSign(sign);
        // then
        assertThat(arithmetic).isEqualTo(Arithmetic.MULTIPLICATION);
    }

    @Test
    void 나눗셈_가져오기() {
        // given
        String sign = "/";
        // when
        Arithmetic arithmetic = Arithmetic.findSign(sign);
        // then
        assertThat(arithmetic).isEqualTo(Arithmetic.DIVIDE);
    }

    @Test
    void 덧셈_하기() {
        // given
        Arithmetic arithmetic = Arithmetic.findSign("+");
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        // when
        Number result = arithmetic.calculate().apply(number1, number2);
        // then
        assertThat(result).isEqualTo(new Number(3));
    }

    @Test
    void 뺄셈_하기() {
        // given
        Arithmetic arithmetic = Arithmetic.findSign("-");
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        // when
        Number result = arithmetic.calculate().apply(number1, number2);
        // then
        assertThat(result).isEqualTo(new Number(-1));
    }

    @Test
    void 곱셈_하기() {
        // given
        Arithmetic arithmetic = Arithmetic.findSign("*");
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        // when
        Number result = arithmetic.calculate().apply(number1, number2);
        // then
        assertThat(result).isEqualTo(new Number(2));
    }

    @Test
    void 나눗셈_하기() {
        // given
        Arithmetic arithmetic = Arithmetic.findSign("/");
        Number number1 = new Number(2);
        Number number2 = new Number(1);
        // when
        Number result = arithmetic.calculate().apply(number1, number2);
        // then
        assertThat(result).isEqualTo(new Number(2));
    }

    @Test
    void 정수로_떨어지지_않는_나눗셈_하기() {
        // given
        Arithmetic arithmetic = Arithmetic.findSign("/");
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        // when

        // then
        assertThatThrownBy(() -> arithmetic.calculate().apply(number1, number2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
