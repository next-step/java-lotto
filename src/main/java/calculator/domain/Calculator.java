package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> operands;

    private final Operators operators;

    private int result = 0;

    public Calculator(String input) {
        validateInput(input);
        String[] inputs = splitInput(input);
        this.operands = operandsFrom(inputs);
        this.operators = new Operators(inputs);
    }

    public List<Integer> operands() {
        return this.operands;
    }


    public Operators operators() {
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

    public int result() {
        result = this.operands.get(0);
        for (int i = 0; i < this.operators.operators().size(); ++i) {
            calculate(i);
        }
        return result;
    }

    private void calculate(int i) {
        switch (this.operators.operators().get(i)) {
            case "+":
                result = sum(result, this.operands.get(i + 1));
                break;
            case "-":
                result = subtraction(result, this.operands.get(i + 1));
                break;
            case "*":
                result = multiplication(result, this.operands.get(i + 1));
                break;
            case "/":
                result = division(result, this.operands.get(i + 1));
                break;
        }
    }
}
