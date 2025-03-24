package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

    @Test
    @DisplayName("문자열 사칙 연산 계산기 테스트")
    void start() {
        CalculatorController calculatorController = new CalculatorController();

        int result = calculatorController.start("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }
}