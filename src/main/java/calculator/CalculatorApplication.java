package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;

import java.util.List;

public class CalculatorApplication {
    public static void main(String[] args) {
        List<String> operators = InputView.inputOperators();

        Calculator calculator = Calculator.of(operators);
    }
}
