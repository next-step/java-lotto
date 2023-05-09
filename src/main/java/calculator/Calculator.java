package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final String separator = " ";

    private final List<Operator> operators;
    private final List<Operand> operands;

    private Calculator(List<Operator> operators, List<Operand> operands) {
        this.operators = operators;
        this.operands = operands;
    }

    public static Calculator create(String input) {
        validate(input);
        List<String> tokens = Arrays.asList(input.split(separator));
        List<Operator> operators = new ArrayList<>();
        List<Operand> operands = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            addOperandIfEven(operands, i, tokens);
            addOperatorsIfOdd(operators, i, tokens);
        }

        return create(operators, operands);
    }

    private static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(String.format("String \"%s\" is empty", input));
        }
    }

    private static void addOperatorsIfOdd(List<Operator> operators, int i, List<String> tokens) {
        if(i % 2 == 1) {
            operators.add(Operators.create(tokens.get(i)));
        }
    }

    private static void addOperandIfEven(List<Operand> operands, int i, List<String> tokens) {
        if (i % 2 == 0) {
            operands.add(Operand.create(tokens.get(i)));
        }
    }

    private static Calculator create(List<Operator> operators, List<Operand> operands) {
        return new Calculator(operators, operands);
    }

    public int calculate() {
        int result = operands.get(0).value();
        for (int operatorIndex = 0; operatorIndex < operators.size(); operatorIndex++) {
            int operandIndex = operatorIndex + 1;
            result = operators.get(operatorIndex).calculate(Operand.create(result), operands.get(operandIndex));
        }
        return result;
    }
}
