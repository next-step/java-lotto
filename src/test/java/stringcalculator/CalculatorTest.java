package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void null입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(null))
                .withMessageContaining("문자열을 입력해주세요.");
    }

    @Test
    void 빈문자열입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate("          "))
                .withMessageContaining("문자열을 입력해주세요.");
    }

    @Test
    void 덧셈() {
        int result = Calculator.calculate("1 + 2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        int result = Calculator.calculate("1 - 2");

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        int result = Calculator.calculate("1 * 2");

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        int result = Calculator.calculate("1 / 2");

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 종합() {
        int result = Calculator.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }
    @Test
    void 공백으로_끝() {
        int result = Calculator.calculate("2 + 3 * 4 / 2 ");

        assertThat(result).isEqualTo(10);
    }
    @Test
    void 연산자로_끝() {
        int result = Calculator.calculate("2 + 3 * 4 / 2 *");

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 연산자_아닐때() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate("1 a 3"))
                .withMessageContaining("사칙 연산 기호가 아닙니다.");
    }
}
