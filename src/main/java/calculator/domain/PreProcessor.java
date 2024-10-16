package calculator.domain;

import calculator.model.Operands;
import calculator.model.Operators;

import java.util.Arrays;
import java.util.List;

public class PreProcessor {
    private static final String DELIMITER = " ";
    private Operands operands;
    private Operators operators;

    public PreProcessor() {
        this.operands = new Operands();
        this.operators = new Operators();
    }

    public void process(String input) {
        List<String> tokens = Arrays.asList(input.split(DELIMITER));
        for (int i = 0; i < tokens.size(); i++) {
            if (isEven(i)) {
                Operand operand = new Operand(convertToInteger(tokens.get(i)));
                this.operands.addOperand(operand);
            }

            if (isOdd(i)) {
                this.operators.addOperator(Operator.getInstance(tokens.get(i)));
            }
        }
    }

    public Operands getOperands() {
        return operands;
    }

    public Operators getOperators() {
        return operators;
    }

    private Integer convertToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자입니다.");
        }
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }
}
