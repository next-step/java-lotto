package calculator.domain;

import calculator.constant.OperationConst;
import calculator.exception.InvalidInputException;

public class StringCalculator {

    private static final String SEPARATOR = " ";
    private static final int INITIAL_NUMBER_IDX = 0;

    public static int calculate(String value) {
        if (isNullOrBlank(value)) {
            throw new InvalidInputException();
        }

        String[] numbersAndSigns = value.split(SEPARATOR);
        Calculator calculator = new Calculator(numbersAndSigns[INITIAL_NUMBER_IDX]);

        Number result = null;
        for (int i = 1; i < numbersAndSigns.length; i=i+2) {
            calculator.changeOperation(OperationConst.findBySign(numbersAndSigns[i]).operation());
            result = calculator.calculate(new Number(numbersAndSigns[i+1]));
        }
        return result.toInt();
    }

    private static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }
}
