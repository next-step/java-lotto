package stringcalculator.domain;

import java.util.ArrayList;

public class Experssion {
    public static final String SPACE = " ";
    public static final String OPERAND_REGEX = "\\d+";
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    private ArrayList<Integer> operands = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();

    public Experssion(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("수식이 입력되지 않았습니다.");
        }

        String[] terms = expression.split(SPACE);

        if (terms.length % 2 == 0) {
            throw new IllegalArgumentException("입력한 수식의 개수가 유효하지 않습니다.");
        }

        for (int i = 0; i < terms.length; i++) {
            addTermToOperandOrOperator(terms[i], i);
        }
    }

    private void addTermToOperandOrOperator(String term, int i) {
        if (i % 2 == 0) {
            validateOperand(term);
            operands.add(Integer.parseInt(term));
        }

        if (i % 2 != 0) {
            validateOperator(term);
            operators.add(term);
        }
    }

    private void validateOperand(String term) {
        if (!term.matches(OPERAND_REGEX)) {
            throw new IllegalArgumentException("입력된 피연산자가 숫자가 아닙니다.");
        }
    }

    private void validateOperator(String term) {
        if (!term.matches(OPERATOR_REGEX)) {
            throw new IllegalArgumentException("입력된 연산자가 사칙연산자가 아닙니다.");
        }
    }

    public int reduce() {
        int result = operands.get(0).intValue();

        for (int i = 0; i < operators.size(); i++) {
            result = calculate(result, operands.get(i + 1).intValue(), operators.get(i));
        }

        return result;
    }

    private int calculate(int x, int y, String operator) {
        int result = 0;

        switch (operator) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
        }

        return result;
    }
}
