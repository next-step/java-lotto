package step1.domain.calculator;

import step1.domain.operator.Operation;
import step1.domain.operator.Operator;

public class Calculator {

    public int calculate(String[] inputValues) {
        int result = Integer.valueOf(inputValues[0]);
        for (int i = 1; i < inputValues.length; i += 2) {
            Operator operator = Operation.from(inputValues[i]).getOperator();
            result = operator.operate(result, Integer.valueOf(inputValues[i + 1]));
        }
        return result;
    }
}
