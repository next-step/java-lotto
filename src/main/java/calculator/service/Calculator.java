package calculator.service;

import static calculator.service.Operator.*;

public class Calculator {

    private static int result = 0;

    public int calculate(String[] input) throws Exception {
        result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i += 2) {
            result = getOperator(input[i]).operate(result, Integer.parseInt(input[i+1]));
        }
        return result;
    }
}