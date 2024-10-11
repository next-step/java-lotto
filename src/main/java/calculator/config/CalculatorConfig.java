package calculator.config;

import calculator.controller.CalculatorController;
import calculator.domain.StringCalculator;
import calculator.service.CalculatorService;
import calculator.strategy.CalculationOrderStrategy;
import calculator.strategy.InputOrder;

public class CalculatorConfig {
    public static CalculatorController calculatorController() {
        return new CalculatorController(calculatorService());
    }

    private static CalculatorService calculatorService() {
        return new CalculatorService(stringCalculator());
    }

    private static StringCalculator stringCalculator() {
        return new StringCalculator(calculationOrderStrategy());
    }

    private static CalculationOrderStrategy calculationOrderStrategy() {
        return new InputOrder();
    }
}
