package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private final List<Operator> operators;
    private final List<Operand> operands;

    private Calculator(List<Operator> operators, List<Operand> operands) {
        this.operators = operators;
        this.operands = operands;
    }

    public static Calculator create(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(String.format("String \"%s\" is empty", input));
        }
        List<String> tokens = Arrays.asList(input.split(" "));
        List<Operator> operators = new ArrayList<>();
        List<Operand> operands = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            if (i % 2 == 0) {
                operands.add(Operand.create(tokens.get(i)));
            } else {
                operators.add(Operators.create(tokens.get(i)));
            }
        }

        return create(operators, operands);
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
