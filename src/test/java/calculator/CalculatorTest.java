package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void spilt_test() {
        String rawString = "1 + 1";
        String[] seperateString = rawString.split(" ");
        System.out.println(seperateString.length);
        System.out.println(Arrays.toString(seperateString));
    }

    @Test
    void 더하기() {
        String str = "1 + 1 + 1";
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(str)).isEqualTo(3);
    }

    @Test
    void 곱하기() {
        String str = "1 * 1 * 1";
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(str)).isEqualTo(1);
    }

    @Test
    void 나누기() {
        String str = "1 / 1 / 1";
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(str)).isEqualTo(1);
    }

    @Test
    void 빼기() {
        String str = "2 - 1 - 1";
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(str)).isEqualTo(0);
    }

    @Test
    void 복합연산() {
        String str = "2 + 3 * 4 / 3";
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(str)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void null_공백_입력(String input) {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산식을 입력해주세요");
    }

    @Test
    void 사칙연산자_아님() {
        String str = "2 & 3";
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculator(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호만 입력해주세요");
    }
}
