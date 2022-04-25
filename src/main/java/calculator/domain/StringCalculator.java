package calculator.domain;

import calculator.constant.OperationConst;

public class StringCalculator {

    public static int calculate(String value) {
        if (isNullOrBlank(value)) {
            throw new IllegalArgumentException();
        }

        String[] values = value.split(" ");
        Calculator calculator = new Calculator(values[0]);
        int result = 0;
        for (int i = 1; i < values.length; i++) {
            if (i % 2 == 1) {
                calculator.changeOperation(OperationConst.findBySign(values[i]).operation());
            } else {
                result = calculator.calculate(Integer.parseInt(values[i]));
            }
        }

        return result;
    }

    private static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }
}
