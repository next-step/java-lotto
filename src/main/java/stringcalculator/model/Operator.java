package stringcalculator.model;

import java.util.LinkedList;
import java.util.Queue;

import static stringcalculator.model.Operand.OPERAND_REGEX;

public class Operator {
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    private Queue<String> operator = new LinkedList<>();

    public Operator() {
    }

    public Operator(String text) {
        this.checkOtherOperator(text);
    }

    public Operator(String[] textArr) {
        for (String text : textArr) {
            addOperator(text);
        }
    }

    private void addOperator(String text) {
        this.checkOtherOperator(text);
        if (text.matches(OPERATOR_REGEX)) {
            operator.add(text);
        }
    }

    private void checkOtherOperator(String text) {
        if (!text.matches(OPERATOR_REGEX) && !text.matches(OPERAND_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    int operate(int i, int j) {
        String operatorText = this.pop();
        if (operatorText.equals("+")) {
            return this.add(i, j);
        }
        if (operatorText.equals("-")) {
            return this.minus(i, j);
        }
        if (operatorText.equals("*")) {
            return this.multiply(i , j);
        }
        if (operatorText.equals("/")) {
            return this.division(i, j);
        }
        return 0;
    }

    String pop() {
        return operator.remove();
    }

    public int add(int i, int j) {
        return i + j;
    }

    public int minus(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int division(int i, int j) {
        return i / j;
    }
}
