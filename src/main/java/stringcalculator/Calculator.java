package stringcalculator;


import stringcalculator.arithmetic.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final String NOT_SUPPORT_ARITHMETIC = "지원되는 연산자가 아닙니다.";
    private final Map<String, ArithmeticOperation> operationMap = new HashMap<>();

    public Calculator() {
        operationMap.put("+", new Add());
        operationMap.put("-", new Sub());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());
    }

    public int calculate(int firstNumber, int secondNumber, String arithmetic) {
        ArithmeticOperation operation = operationMap.get(arithmetic);
        validArithmeticSupports(operation);
        return operation.calculate(firstNumber, secondNumber);
    }

    private void validArithmeticSupports(ArithmeticOperation operation) {
        if (operation == null) {
            throw new IllegalArgumentException(NOT_SUPPORT_ARITHMETIC);
        }
    }
}
