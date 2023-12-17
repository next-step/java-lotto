package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 - 1")).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplyTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 * 3")).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("4 / 2")).isEqualTo(2);
    }

    @Test
    @DisplayName("통합 계산 테스트")
    void calculateTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("나누어진 값이 정수인지 확인")
    void divideIntegerTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("5 / 2")).isNotEqualTo(2.5);
        assertThat(calculator.calculate("5 / 2")).isEqualTo(2);
    }

    @Test
    @DisplayName("input 값이 null 이거나 빈값인 경우 exception 발생")
    void inputNullorEmptyTest() {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(null);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("");
        });
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 기호가 입력 됨")
    void inputNotOperatorTest() {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("1 # 2");
        });
    }

}
