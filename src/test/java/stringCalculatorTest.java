

import controller.CalculatorController;
import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class stringCalculatorTest {

    @Test
    @DisplayName("문자열 계산")
    public void calculator() {

        Calculator calculator = new Calculator(4);
        assertThat(calculator.getNowValue()).isEqualTo(4);

        assertThat(calculator.operation(2, "-")).isEqualTo(2);
        assertThat(calculator.operation(2, "+")).isEqualTo(6);
        assertThat(calculator.operation( 2, "/")).isEqualTo(2);
        assertThat(calculator.operation( 3, "*")).isEqualTo(12);

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.operation(2, "a"));
    }

    @Test
    @DisplayName("입력값 예외")
    public void exception() {
        CalculatorController calculatorController = new CalculatorController();

        assertThatIllegalArgumentException().isThrownBy(() -> calculatorController.input()).withMessage("잘못된 입력값 입니다");
    }
}