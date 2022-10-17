package stringcalculator;


import stringcalculator.arithmetic.*;

import java.util.HashMap;
import java.util.Map;

import static stringcalculator.InputValidator.validateArithmeticSupports;
import static stringcalculator.InputValidator.validateNumeric;

public class StringCalculator {

    private static final Map<String, ArithmeticOperation> OPERATION_MAP = new HashMap<>();
    static {
        OPERATION_MAP.put("+", new Add());
        OPERATION_MAP.put("-", new Sub());
        OPERATION_MAP.put("*", new Multiply());
        OPERATION_MAP.put("/", new Divide());
    }

    private final String[] inputs;

    public StringCalculator(String input) {
        this.inputs = split("+ " + input);
    }

    public int calculate() {
        int result = 0;
        for (int i = 1; i < inputs.length; i += 2) {
            result = calculate(result, toInt(inputs[i]), getOperation(inputs[i - 1]));
        }
        return result;
    }

    private int calculate(int firstNumber, int secondNumber, ArithmeticOperation operation) {
        return operation.calculate(firstNumber, secondNumber);
    }

    private ArithmeticOperation getOperation(String arithmetic) {
        ArithmeticOperation operation = OPERATION_MAP.get(arithmetic);
        validateArithmeticSupports(operation);
        return operation;
    }

    private static String[] split(String source) {
        return source.split(" ");
    }


    private static int toInt(String numberCandidate) {
        validateNumeric(numberCandidate);
        return Integer.parseInt(numberCandidate);
    }
}
