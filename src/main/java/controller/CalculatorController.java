package controller;

import service.Calculator;

import java.util.List;

public class CalculatorController {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();


    public static void main(String[] args) {
        String calculationString = inputView.inputCalculationString();
        List<Integer> numbers = inputView.getNumbers(calculationString);
        List<Character> operations = inputView.getOperations(calculationString);

        Calculator calculator = new Calculator();
        int result = calculator.calculate(numbers, operations);

        resultView.printResult(result);
    }

}
