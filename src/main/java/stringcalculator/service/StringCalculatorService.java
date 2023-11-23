package stringcalculator.service;

import stringcalculator.util.StringCalculator;
import stringcalculator.util.StringUtility;

public class StringCalculatorService {
    public static int runCalculator(String string) {
        StringUtility.validateBlankString(string);
        String[] values = StringUtility.split(string);
        StringUtility.validateOperator(values);

        return calculateStrings(values);
    }

    private static int calculateStrings(String[] values) {
        int result = StringUtility.convertToInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            result = calculateDependsOnOperator(result, values[i], StringUtility.convertToInt(values[i + 1]));
        }

        return result;
    }

    private static int calculateDependsOnOperator(int num1, String operator, int num2) {
        if (operator.equals(Operator.ADD.getOperator())) {
            return StringCalculator.add(num1, num2);
        }
        if (operator.equals(Operator.SUB.getOperator())) {
            return StringCalculator.subtract(num1, num2);
        }
        if (operator.equals(Operator.MUL.getOperator())) {
            return StringCalculator.multiply(num1, num2);
        }
        if (operator.equals(Operator.DIV.getOperator())) {
            return StringCalculator.divide(num1, num2);
        }

        return 0;
    }
}
