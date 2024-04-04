package calculator.service;

import calculator.domain.Operator;
import util.StringValidator;

public class CalculatorServiceImpl implements CalculatorService{

    private static final StringValidator validator = new StringValidator();

    @Override
    public Integer parseAndCalculate(String input) {
        validator.validateCalculated(input);
        String[] inputArr = getParsedString(input);
        int preNum = Integer.parseInt(inputArr[0]);
        String symbol = inputArr[1];
        int postNum = Integer.parseInt(inputArr[2]);
        Operator operator = Operator.getOperator(symbol);
        return operator.calculate(preNum, postNum);
    }

    private static String[] getParsedString(String input) {
        String[] inputArr = input.split(" ");
        return inputArr;
    }

}
