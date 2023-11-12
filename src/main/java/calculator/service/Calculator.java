package calculator.service;

import static calculator.service.Operator.*;

public class Calculator {

    private static int result = 0;
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public static int calculate(String[] input) throws Exception {
        result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i += 2) {
            result = getEnum(input[i]).operate(result, Integer.parseInt(input[i+1]));
        }
        return result;
    }
}
