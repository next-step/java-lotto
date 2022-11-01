package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CalculatorTest {
    @Test
    void init(){
        assertThatThrownBy(() -> new Calculator(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");

        assertThatThrownBy(() -> new Calculator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
    }

    @Test
    void one_operator(){
        Calculator calculator = new Calculator("1 + 2");
        assertThat(calculator.calculate()).isEqualTo("3");

        Calculator calculator2 = new Calculator("1 * -5");
        assertThat(calculator2.calculate()).isEqualTo("-5");
    }

    @Test
    void two_operator(){
        Calculator calculator = new Calculator("1 + 2 - 3");
        assertThat(calculator.calculate()).isEqualTo("0");

        Calculator calculator2 = new Calculator("1 * -5 / 2");
        assertThat(calculator2.calculate()).isEqualTo("-2");
    }
}