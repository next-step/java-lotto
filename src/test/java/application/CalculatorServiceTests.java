package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTests {
    private CalculatorService calculatorService;

    @BeforeEach
    public void setup() {
        calculatorService = new CalculatorService();
    }

    @DisplayName("InputView를 입력받아서 연산 수행한 뒤 정수형 결과값 반환")
    @Test
    void calculatorServiceTest() {
        InputView inputView = InputView.create("1,2,3,4,5");
        int sum = calculatorService.calculateSum(inputView);
        assertThat(sum).isEqualTo(15);
    }
}
