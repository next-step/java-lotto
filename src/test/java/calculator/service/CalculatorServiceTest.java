package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.InputValue;
import calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-09-27
 */
class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService(new Calculator());

    @Test
    void 더하기() {
        List<InputValue> inputValues = List.of(new InputValue("3"),
                new InputValue("+"),
                new InputValue("2"));

        assertThat(calculatorService.calculate(inputValues)).isEqualTo(5);
    }

    @Test
    void 빼기() {
        List<InputValue> inputValues = List.of(new InputValue("3"),
                new InputValue("-"),
                new InputValue("2"));

        assertThat(calculatorService.calculate(inputValues)).isEqualTo(1);
    }

    @Test
    void 곱하기() {
        List<InputValue> inputValues = List.of(new InputValue("3"),
                new InputValue("*"),
                new InputValue("2"));

        assertThat(calculatorService.calculate(inputValues)).isEqualTo(6);
    }

    @Test
    void 나누기() {
        List<InputValue> inputValues = List.of(new InputValue("3"),
                new InputValue("/"),
                new InputValue("3"));

        assertThat(calculatorService.calculate(inputValues)).isEqualTo(1);
    }

    @Test
    void 연산() {
        List<InputValue> inputValues = List.of(new InputValue("2"),
                new InputValue("+"),
                new InputValue("3"),
                new InputValue("*"),
                new InputValue("4"),
                new InputValue("2"));

        assertThat(calculatorService.calculate(inputValues)).isEqualTo(10);
    }
}
