package stringcalculator;


import stringcalculator.arithmetic.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final Map<String, ArithmeticOperation> OPERATION_MAP = new HashMap<>();
    public static final String NOT_SUPPORT_ARITHMETIC = "지원되는 연산자가 아닙니다.";

    static {
        OPERATION_MAP.put("+", new Add());
        OPERATION_MAP.put("-", new Sub());
        OPERATION_MAP.put("*", new Multiply());
        OPERATION_MAP.put("/", new Divide());
    }

    private Calculator() {}

    public static int calculate(int firstNumber, int secondNumber, String arithmetic) {
        ArithmeticOperation operation = OPERATION_MAP.get(arithmetic);
        validArithmeticSupports(operation);
        return operation.calculate(firstNumber, secondNumber);
    }

    private static void validArithmeticSupports(ArithmeticOperation operation) {
        if (operation == null) {
            throw new IllegalArgumentException(NOT_SUPPORT_ARITHMETIC);
        }
    }
}
