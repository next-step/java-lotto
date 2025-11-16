package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void null_입력시_예외를_발생시킨다() {
        assertThatThrownBy(() -> Calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_입력시_예외를_발생시킨다() {
        assertThatThrownBy(() -> Calculator.calculate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_문자열_입력시_예외를_발생시킨다() {
        assertThatThrownBy(() -> Calculator.calculate("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 덧셈_계산을_수행한다() {
        int result = Calculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈_계산을_수행한다() {
        int result = Calculator.calculate("5 - 3");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 곱셈_계산을_수행한다() {
        int result = Calculator.calculate("3 * 4");
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 나눗셈_계산을_수행한다() {
        int result = Calculator.calculate("8 / 2");
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 연속_계산을_순서대로_수행한다() {
        int result = Calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

}
