package calculator.controller;

import calculator.domain.Number;
import calculator.domain.Operator;
import calculator.service.CalculatorService;
import java.util.List;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int calculator(String input) {
        List<String> splitResult = calculatorService.getOperations(input);

        List<Number> numbers = calculatorService.getNumbers(splitResult);           // 숫자들 모음
        List<Operator> operators = calculatorService.getOperators(splitResult);     // 연산 모음

        return calculatorService.calculate(numbers, operators);
    }

}
