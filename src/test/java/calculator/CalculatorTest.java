package calculator;

import calculator.controller.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import calculator.service.CalculatorService;
import calculator.service.Preprocessor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CalculatorTest {
    CalculatorService calculatorService = new CalculatorService();;

    @DisplayName("입력값 null or ''")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void inputForNullAndEmpty(String value) {
        Preprocessor preprocessor = new Preprocessor();
        boolean isEmpty = preprocessor.verificationOfInputValue(value);
        assertFalse(isEmpty);
    }

    @DisplayName("유효한 입력값 확인")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 2", "3 - 1", "4 * 5", "8 / 2"})
    public void inputForValidExpressions(String value) {
        Preprocessor preprocessor = new Preprocessor();
        assertThat(preprocessor.verificationOfInputValue(value)).isTrue();
    }

    @DisplayName("계산기에서 더하기 연산 결과 확인")
    @Test
    public void plus() {
        int calculatedValue = calculatorService.calculate("3 + 5");
        assertThat(8).isEqualTo(calculatedValue);
    }

    @DisplayName("계산기에서 빼기 연산 결과 확인")
    @Test
    public void minus() {
        int calculatedValue = calculatorService.calculate("10 - 4");
        assertThat(6).isEqualTo(calculatedValue);
    }

    @DisplayName("계산기에서 곱하기 연산 결과 확인")
    @Test
    public void multiplication() {
        int calculatedValue = calculatorService.calculate("3 * 4");
        assertThat(12).isEqualTo(calculatedValue);
    }

    @DisplayName("계산기에서 나누기 연산 결과 확인")
    @Test
    public void division() {
        int calculatedValue = calculatorService.calculate("8 / 2");
        assertThat(4).isEqualTo(calculatedValue);
    }

    @Test
    @DisplayName("계산기 최종 결과값 출력")
    public void calculateResult() {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
