package stringcalculator.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Experssion {
    public static final String SPACE = " ";
    public static final String OPERAND_REGEX = "\\d+";
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    private ArrayList<Integer> operands = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();
    private Map<String, Operator> operatorMap = new HashMap<>();

    public Experssion(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("수식이 입력되지 않았습니다.");
        }

        String[] terms = splitExpression(expression);

        for (int i = 0; i < terms.length; i++) {
            addTermToOperandOrOperator(terms[i], i);
        }
    }

    private String[] splitExpression(String expression) {
        String[] terms = expression.split(SPACE);

        if (terms.length % 2 == 0) {
            throw new IllegalArgumentException("입력한 수식의 개수가 유효하지 않습니다.");
        }
        return terms;
    }

    private void addTermToOperandOrOperator(String term, int i) {
        addOperandIfEven(term, i);

        addOperatorIfOdd(term, i);
    }

    private void addOperatorIfOdd(String term, int i) {
        if (i % 2 != 0) {
            validateOperator(term);
            operators.add(term);
        }
    }

    private void addOperandIfEven(String term, int i) {
        if (i % 2 == 0) {
            validateOperand(term);
            operands.add(Integer.parseInt(term));
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
        createOperatorMap();

        int result = operands.get(0).intValue();

        for (int i = 0; i < operators.size(); i++) {
            result = operatorMap.get(operators.get(i)).calculate(result, operands.get(i + 1).intValue());
        }

        return result;
    }

    private void createOperatorMap() {
        operatorMap.put("+", new Addition());
        operatorMap.put("-", new Substraction());
        operatorMap.put("*", new Multiplication());
        operatorMap.put("/", new Division());
    }
}
