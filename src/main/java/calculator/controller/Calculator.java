package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.Input;
import calculator.view.Output;

public class Calculator {

    public void start() {
        Input input = new Input();
        String inputValue = input.inputValue();

        CalculatorService calculatorService = new CalculatorService();
        int calculatedValue = calculatorService.calculate(inputValue);

        Output output = new Output();
        output.outputValue(calculatedValue);
    }

}
