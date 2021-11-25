package step1.calculator;

import step1.calculator.operand.NumberOperand;
import step1.calculator.operand.NumberOperands;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String inputStr) {
        NumberOperands numberOperands = NumberOperands.from(inputStr);
        List<NumberOperand> operands = numberOperands.getOperands();

        int ret = 0;
        for (NumberOperand operand : operands) {
            ret = operand.plus(ret);
        }

        return ret;
    }

}