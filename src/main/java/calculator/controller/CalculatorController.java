package calculator.controller;

import calculator.service.StringCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.List;

public class CalculatorController {
    private static CalculatorController instance;

    public static CalculatorController getInstance() {
        if (instance == null) {
            instance = new CalculatorController();
        }
        return instance;
    }

    public void startCalculator() {
        try {
            List<String> numbersAndSings = InputView.getUserInput();
            int resultNumber = new StringCalculator().calculator(numbersAndSings);
            ResultView.showCalculationResult(resultNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startCalculator();
        }
    }
}
