package stringCalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static String DELIMITER = " ";

    private List<Operand> operands;
    private List<Operator> operators;

    public Calculator(String inputText) {
        this.operands = new ArrayList<>();
        this.operators = new ArrayList<>();

        create(inputText);
    }

    private void create(String inputText) {
        isEmpty(inputText);

        List<String> splitText = Arrays.asList(inputText.split(DELIMITER));

        for(int index = 0; index < splitText.size(); index++) {
            addOperand(index, splitText.get(index));
            addOperators(index, splitText.get(index));
        }
    }

    public int calculate() {
        int result = operands.get(0).getValue();

        for (int index = 0; index < operators.size(); index++) {
            int operandIndex = index + 1;
            result = operators.get(index).calculate(result, operands.get(operandIndex).getValue());
        }
        return result;
    }

    private void isEmpty(String inputText) {
        if(inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException("문자열이 올바르지 않습니다.");
        }
    }

    private void addOperators(int index, String text) {
        if(index % 2 == 1) {
            this.operators.add(new Operator(text));
        }
    }

    private void addOperand(int index, String text) {
        if (index % 2 == 0) {
            this.operands.add(new Operand(text));
        }
    }
}
