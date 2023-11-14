import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringCalculator.domain.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("계산기에 +를 사용하먄 전달받은 두 수를 더한다.")
    @Test
    void calculatorPlusTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("+", 1, 2)).isEqualTo(3);
        assertThat(calculator.calculate("+", 3, 2)).isEqualTo(5);
    }

    @DisplayName("계산기에 -를 사용하면 전달받은 두 수를 뺀다.")
    @Test
    void calculatorMinusTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("-", 2, 1)).isEqualTo(1);
        assertThat(calculator.calculate("-", 5, 2)).isEqualTo(3);
    }

    @DisplayName("계산기에 *를 사용하면 전달받은 두 수를 곱한다.")
    @Test
    void calculatorMultiplyTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("*", 2, 1)).isEqualTo(2);
        assertThat(calculator.calculate("*", 3, 2)).isEqualTo(6);
    }

    @DisplayName("계산기에 /를 사용하면 전달받은 두 수를 나눈다. 단, 결과값은 정수로 반환한다.")
    @Test
    void calculatorDivideTest(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("/", 2, 1)).isEqualTo(2);
        assertThat(calculator.calculate("/", 5, 2)).isNotEqualTo(2.5);
    }

    @DisplayName("계산기에 사칙연산 외 특수문자를 전달하면 에러를 발생시킨다.")
    @Test
    void calculatorOperatorTest() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculate("?", 1, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산을 제외한 문자는 계산할 수 없습니다.");
    }
}
