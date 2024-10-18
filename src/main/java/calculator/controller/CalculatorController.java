package calculator.controller;

import calculator.domain.Input;
import calculator.service.CalculatorService;
import calculator.view.View;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final View view;

    public CalculatorController(final CalculatorService calculatorService, final View view) {
        this.calculatorService = calculatorService;
        this.view = view;
    }

    public void run() {
        Input input = view.input();

        int result = calculatorService.calculate(input);

        view.output(result);
    }
}
