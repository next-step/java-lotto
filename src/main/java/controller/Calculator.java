package controller;

import service.CalculatorService;
import view.Input;
import view.Output;

public class Calculator {

    public void start() {
        Input input = new Input();
        String inputValue = input.inputValue();

        // 로직

        CalculatorService calculatorService = new CalculatorService();
        Integer calculatedValue = calculatorService.calculate(inputValue);

        Output output = new Output();
        output.outputValue(calculatedValue);

    }

}
