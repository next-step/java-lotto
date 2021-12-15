package step1.calculator;

import step1.calculator.operand.NumberOperand;
import step1.calculator.operand.NumberOperands;

import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator(){}

    public static int splitAndSum(String inputStr) {
        NumberOperands numberOperands = NumberOperands.from(inputStr);
        List<NumberOperand> operands = numberOperands.getOperands();

        int sum = 0;
        for (NumberOperand operand : operands) {
            sum = operand.plus(sum);
        }

        return sum;
    }

}