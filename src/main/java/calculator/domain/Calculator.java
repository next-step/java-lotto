package calculator.domain;

import calculator.domain.Operators.Operator;
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

    public int result() {
        return this.result;
    }

    public void calculate() {
        result = this.operands.get(0);
        for (int i = 0; i < this.operators.operators().size(); ++i) {
            result = this.operators.operators().get(i).calculate(result, this.operands.get(i + 1));
        }
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


}
