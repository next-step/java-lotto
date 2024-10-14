package controller;

import service.calculator.Calculator;

import java.util.List;

public class CalculatorController {
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        String calculationString = InputView.inputCalculationString();
        List<Integer> numbers = InputView.getNumbers(calculationString);
        List<Character> operations = InputView.getOperations(calculationString);

        int result = calculator.calculate(numbers, operations);

        ResultView.printResult(result);
    }

}
