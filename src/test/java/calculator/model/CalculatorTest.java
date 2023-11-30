package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 덧셈() {
        Calculator calculator = new Calculator("1 + 2");

        assertThat(calculator.result()).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        Calculator calculator = new Calculator("3 - 1");

        assertThat(calculator.result()).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        Calculator calculator = new Calculator("3 * 2");

        assertThat(calculator.result()).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        Calculator calculator = new Calculator("10 / 2");

        assertThat(calculator.result()).isEqualTo(5);
    }

    @Test
    void 덧셈_뺄셈() {
        Calculator calculator = new Calculator("1 + 5 - 3");

        assertThat(calculator.result()).isEqualTo(3);
    }

    @Test
    void 덧셈_뺄셈_곱셈() {
        Calculator calculator = new Calculator("1 + 5 - 3 * 6");

        assertThat(calculator.result()).isEqualTo(18);
    }

    @Test
    void 덧셈_뺄셈_곱셈_나눗셈() {
        Calculator calculator = new Calculator("1 + 5 - 3 * 6 / 9");

        assertThat(calculator.result()).isEqualTo(2);
    }

    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    void input_blank() {
        assertThatThrownBy(() -> {
            new Calculator(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Calculator("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void not_operator() {
        assertThatThrownBy(() -> {
            new Calculator("1 @ 3");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new Calculator("2 $ 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
