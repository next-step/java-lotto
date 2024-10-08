package calculator.controller;

import calculator.domain.Input;
import calculator.dto.CalculationResult;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(final CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        Input input = InputView.input();

        CalculationResult calculationResult = calculatorService.calculate(input);

        OutputView.output(calculationResult);
    }
}
