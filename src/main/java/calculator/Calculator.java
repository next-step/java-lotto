package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> operands;

    private final List<String> operators;

    private int result = 0;

    public Calculator(String input) {
        validateInput(input);
        String[] inputs = splitInput(input);
        this.operands = operandsFrom(inputs);
        this.operators = operatorsFrom(inputs);
    }

    public List<Integer> operands() {
        return this.operands;
    }


    public List<String> operators() {
        return this.operators;
    }

    private void validateInput(String input) {
        boolean isNull = input == null;
        if (isNull) {
            throw new IllegalArgumentException("input is null.");
        }
        boolean isEmpty = input.isEmpty();
        if (isEmpty) {
            throw new IllegalArgumentException("input is empty string.");
        }
    }

    private String[] splitInput(String input) {
        return input.split(" ");
    }

    private List<Integer> operandsFrom(String[] inputs) {
        int i = 0;
        List<Integer> operands = new ArrayList<>();
        for (String o : inputs) {
            addOperand(i, operands, o);
            ++i;
        }
        return operands;
    }

    private static void addOperand(int i, List<Integer> operands, String o) {
        if (i % 2 == 0) {
            operands.add(Integer.parseInt(o));
        }
    }

    private List<String> operatorsFrom(String[] inputs) {
        int i = 0;
        List<String> operators = new ArrayList<>();
        for (String o : inputs) {
            addOperator(i, operators, o);
            ++i;
        }
        return operators;
    }

    private void validateOperator(String o) {
        if (!o.equals("+") && !o.equals("-") && !o.equals("*") && !o.equals("/")) {
            throw new IllegalArgumentException();
        }
    }

    private void addOperator(int i, List<String> operators, String o) {
        if (i % 2 != 0) {
            validateOperator(o);
            operators.add(o);
        }
    }

    public int sum(int operand1, int operand2) {
        result = operand1 + operand2;
        return result;
    }

    public int subtraction(int operand1, int operand2) {
        result = operand1 - operand2;
        return result;
    }

    public int multiplication(int operand1, int operand2) {
        result = operand1 * operand2;
        return result;
    }

    public int division(int operand1, int operand2) {
        result = operand1 / operand2;
        return result;
    }
}
