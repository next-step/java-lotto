package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void split() {
        assertThat(getSplit("1 + 2")).containsExactly("1", "+", "2");
    }

    @Test
    void 덧셈() {
        Plus plus = new Plus();
        assertThat(plus.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        Minus minus = new Minus();
        assertThat(minus.calculate(3, 1)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        Multiply multiply = new Multiply();
        assertThat(multiply.calculate(3, 2)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        Divide divide = new Divide();
        assertThat(divide.calculate(6, 2)).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void 입력값이_빈문자열_또는_공백이면_IllegalArgumentException_에러를_발생시킨다(String input) {
        assertThatThrownBy(() -> isBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 빈문자열 또는 공백입니다.");
    }


    @Test
    void 계산() {
        StringCalculator cal = new StringCalculator();
        assertThat(cal.calculate("2 + 3 * 4 / 2 * 6 + 4 / 2")).isEqualTo(32);
    }

}
