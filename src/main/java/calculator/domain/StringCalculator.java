package calculator.domain;

import calculator.constant.Operations;
import calculator.exception.InvalidInputException;
import calculator.exception.NotSupportInstanceException;

public class StringCalculator {

    private static final String SEPARATOR = " ";
    private static final int INITIAL_NUMBER_IDX = 0;
    private static final int START_INDEX = 1;
    private static final int STEP_UNIT = 2;

    private StringCalculator() {
        throw new NotSupportInstanceException();
    }

    public static int calculate(String value) {
        if (isNullOrBlank(value)) {
            throw new InvalidInputException();
        }

        String[] numbersAndSigns = value.split(SEPARATOR);
        Operator operator = new Operator(numbersAndSigns[INITIAL_NUMBER_IDX]);
        for (int i = START_INDEX; i < numbersAndSigns.length; i=i+STEP_UNIT) {
            operator.changeOperation(Operations.findBySign(numbersAndSigns[i]).operation());
            operator.calculate(Integer.parseInt(numbersAndSigns[i+1]));
        }
        return operator.result();
    }

    private static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }
}
