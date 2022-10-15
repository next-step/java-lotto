package calculator;

import utils.StringSplit;

public class Calculator {
    public static int from(String express) {
        return calculate(express);
    }

    private static int calculate(String input) {
        String[] str = StringSplit.split(input);
        int result = Integer.parseInt(str[0]);
        for (int i = 1; i < str.length - 1; i += 2) {
            Operator operator = OperatorMap.getOperator(str[i]);
            result = operator.execute(result, Integer.parseInt(str[i + 1]));
        }
        return result;
    }
}
