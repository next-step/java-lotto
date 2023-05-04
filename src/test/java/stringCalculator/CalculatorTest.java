package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringCalculator.domain.Calculator;
import stringCalculator.domain.Operand;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("사칙연산 더하기 문자열이 들어오면 덧셈을 진행한다.")
    @Test
    public void calculatorTest_더하기() {
        Calculator calculator = new Calculator("2 + 5 + 3");

        assertThat(calculator.calculate()).isEqualTo(10);
    }

    @DisplayName("사칙연산 빼기 문자열이 들어오면 뺄샘을 진행한다.")
    @Test
    public void calculatorTest_빼기() {
        Calculator calculator = new Calculator("2 - 5 - 3");

        assertThat(calculator.calculate()).isEqualTo(-6);
    }

    @DisplayName("사칙연산 곱하기 문자열이 들어오면 곱셈을 진행한다.")
    @Test
    public void calculatorTest_곱하기() {
        Calculator calculator = new Calculator("2 * 5 * 3");

        assertThat(calculator.calculate()).isEqualTo(30);
    }

    @DisplayName("사칙연산 나누기 문자열이 들어오면 나눗셈을 진행한다.")
    @Test
    public void calculatorTest_나누기() {
        Calculator calculator = new Calculator("6 / 3");

        assertThat(calculator.calculate()).isEqualTo(2);
    }

    @DisplayName("다양한 사칙연산 문자열이 들어오면 사칙연산 진행한다.")
    @Test
    public void calculatorTest_전체사칙연산_테스트() {
        Calculator calculator = new Calculator("2 + 5 - 3 * 5 / 10");

        assertThat(calculator.calculate()).isEqualTo(2);
    }
}
