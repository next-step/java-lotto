package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.InputValue;

import java.util.List;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculate(List<InputValue> inputValues) {
        for (InputValue inputValue : inputValues) {
            calculator.calculate(inputValue);
        }

        return calculator.getResult();
    }
}
