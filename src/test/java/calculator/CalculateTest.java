package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculateTest {

    @DisplayName("+만 있는 경우")
    @Test
    void plusTest() throws Exception {
        String str = "2 + 4";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("-만 있는 경우")
    @Test
    void minusTest() throws Exception {
        String str = "2 - 4";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(-2);
    }

    @DisplayName("*만 있는 경우")
    @Test
    void multiplyTest() throws Exception {
        String str = "2 * 4";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(8);
    }

    @DisplayName("/만 있는 경우")
    @Test
    void divisionTest() throws Exception {
        String str = "2 / 4";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isZero();
    }

    @DisplayName("+,- 혼합 연산")
    @Test
    void test1() throws Exception {
        String str = "3 + 4 - 1";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("+,* 혼합 연산")
    @Test
    void test2() throws Exception {
        String str = "3 + 4 * 2";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(14);
    }

    @DisplayName("+,/ 혼합 연산")
    @Test
    void test3() throws Exception {
        String str = "3 + 4 / 2";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("-,/ 혼합 연산")
    @Test
    void test4() throws Exception {
        String str = "3 - 4 / 2";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isZero();
    }

    @DisplayName("-,* 혼합 연산")
    @Test
    void test5() throws Exception {
        String str = "3 - 4 * 2";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(-2);
    }

    @DisplayName("/,* 혼합 연산")
    @Test
    void test6() throws Exception {
        String str = "3 / 4 * 2";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isZero();
    }

    @DisplayName("모든 연산기호 포함")
    @Test
    void test7() throws Exception {
        String str = "2 + 3 * 4 / 2";
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest(name = "입력 값이 null이거나 공백 문자일 경우 예외를 던진다.")
    @ValueSource(strings = {"", " "})
    void test8(String input) throws Exception {
        assertThatThrownBy(() -> {
            new Calculator(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력값이 올바르지 않습니다.");
    }

    @DisplayName("사칙연산 기호가 아닌 경우 예외를 던진다.")
    @Test
    void test9() throws Exception {
        assertThatThrownBy(() -> {
            new Calculator("1 + 1 ? 2");
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("사칙 연산 기호가 아닙니다.");
    }
}
