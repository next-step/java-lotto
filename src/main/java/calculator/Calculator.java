package calculator;

import java.util.List;

public class Calculator {

    private int result;

    public int plus(int result, int value) {
        return  result + value;
    }

    public int minus(int result, int value) {
        return result - value;
    }

    public int multiply(int result, int value) {
        return result * value;
    }

    public int divide(int result, int value) {
        if (result % value != 0) {
            throw new IllegalArgumentException();
        }
        return result/ value;
    }

    public int calc(List<Integer> operands, List<Operator> operators) {
        initialize(operands);
        validateExpression(operands, operators);
        for (int index = 0; index <operators.size(); index++) {
            result = expressCalculating(operands.get(index+1), operators.get(index));
        }
        return result;
    }

    private int expressCalculating(Integer operand, Operator operator) {
        switch (operator) {
            case ADD:
                return plus(result, operand);
            case SUBTRACT:
                return minus(result, operand);
            case MULTIPLY:
                return multiply(result, operand);
            default:
                return divide(result, operand);
        }
    }

    private void validateExpression(List<Integer> operands, List<Operator> operators) {
        if (operands.size() != operators.size()+1) {
            throw new IllegalArgumentException();
        }
    }

    private void initialize(List<Integer> operands) {
        result = operands.get(0);
    }
}
