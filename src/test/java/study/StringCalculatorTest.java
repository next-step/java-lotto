package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    @DisplayName("덧셈")
    void add() {
        String input = "2 + 3";
        assertThat(Calculator.execute(Expression.from(input))).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        String input = "2 - 3";
        assertThat(Calculator.execute(Expression.from(input))).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        String input = "2 * 3";
        assertThat(Calculator.execute(Expression.from(input))).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        String input = "2 / 3";
        assertThat(Calculator.execute(Expression.from(input))).isZero();
    }

    @Test
    @DisplayName("복합 연산")
    void advancedOperate() {
        String input = "2 + 3 * 4 / 2";
        assertThat(Calculator.execute(Expression.from(input))).isEqualTo(10);
    }
}
