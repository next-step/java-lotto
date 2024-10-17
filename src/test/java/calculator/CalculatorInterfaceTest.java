package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorInterfaceTest {
    @DisplayName("한 줄의 연산 라인을 입력하면 결과값을 반환한다.")
    @Test
    void start() {
        CalculatorInterface calculatorInterface = new CalculatorInterface();

        assertThat(calculatorInterface.start("6 + 6 - 2 * 4 / 2")).isEqualTo(20);
    }
}
