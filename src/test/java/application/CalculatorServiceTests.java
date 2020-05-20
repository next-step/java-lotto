package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
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

    @DisplayName("null이나 빈 문자열로 연산 수행 시 0 반환")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"  ", "     ", ""})
    void calculatorServiceTestWithZeroOrEmpty(String input) {
        InputView inputView = InputView.create(input);
        int sum = calculatorService.calculateSum(inputView);
        assertThat(sum).isEqualTo(0);
    }
}
