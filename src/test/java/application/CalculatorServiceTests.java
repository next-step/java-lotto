package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("숫자 한개짜리 연산")
    @Test
    void calculatorServiceTestWithOne() {
        InputView inputView = InputView.create("1");
        int sum = calculatorService.calculateSum(inputView);
        assertThat(sum).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자")
    @Test
    void calculatorServiceTestWithComma() {
        InputView inputView = InputView.create("1,2");
        int sum = calculatorService.calculateSum(inputView);
        assertThat(sum).isEqualTo(3);
    }

    @DisplayName("쉼표 또는 콜론 구분자")
    @Test
    void calculatorServiceTestWithCommaOrColon() {
        InputView inputView = InputView.create("1,2:3");
        int sum = calculatorService.calculateSum(inputView);
        assertThat(sum).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자")
    @Test
    void calculatorServiceTestWithCustom() {
        InputView inputView = InputView.create("//;\n1;2;3");
        int sum = calculatorService.calculateSum(inputView);
        assertThat(sum).isEqualTo(6);
    }

    @DisplayName("음수 연산")
    @Test
    void calculatorServiceFailTestWithNegativeNumber() {
        assertThatThrownBy(() -> calculatorService.calculateSum(InputView.create("-1,2,3")))
                .isInstanceOf(RuntimeException.class);
    }
}
