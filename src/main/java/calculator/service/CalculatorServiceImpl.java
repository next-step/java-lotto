package calculator.service;

import calculator.domain.Calculator;
import util.StringValidator;

public class CalculatorServiceImpl implements CalculatorService{

    private static final StringValidator validator = new StringValidator();

    @Override
    public Integer parseAndCalculate(String input) {
        validator.validateCalculated(input);
        String[] inputArr = input.split(" ");
        Calculator calculator = new Calculator();
        calculator.calculate(inputArr);
        return calculator.getCalculatedRes();
    }

}
