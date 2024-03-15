package lotto.domain;

import lotto.exception.ExpressionNumberParseException;

import java.util.Queue;

public class Expression {

    private static final String NUMBER_REGEX = "\\d+";
    private static final String ADD_SIGN = "+";
    private static final String SUBTRACT_SIGN = "-";
    private static final String MULTIPLY_SIGN = "*";
    private static final String DIVIDED_SIGN = "/";

    // TODO: 일급 컬렉션을 상태로 가짐으로서 발생하는 .get() 체이닝 문제
    // Calculator -> Expression -> Numbers & Operators (Queue)
    // Calculator -> Expression (2 Queues)
    private final Numbers numbers;
    private final Operators operators;

    public Expression(String[] expressionElements) {
        this.numbers = new Numbers();
        this.operators = new Operators();
        
        for (String element : expressionElements) {
            addNumberOrOperator(element);
        }
    }

    private void addNumberOrOperator(String element) {
        if (isNumber(element)) {
            numbers.add(parseInt(element));
            return;
        }
        operators.add(element);
    }

    private boolean isNumber(String element) {
        return element.matches(NUMBER_REGEX);
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new ExpressionNumberParseException(number);
        }
    }

    public Queue<Integer> getNumbers() {
        return this.numbers.get();
    }

    public Queue<String> getOperators() {
        return this.operators.get();
    }

    public Integer getNumber() {
        return this.numbers.getNumber();
    }

    public String getOperator() {
        return this.operators.getOperator();
    }

    public boolean isAddSign(String operator) {
        return ADD_SIGN.equals(operator);
    }

    public boolean isSubtractSign(String operator) {
        return SUBTRACT_SIGN.equals(operator);
    }

    public boolean isMultiplySign(String operator) {
        return MULTIPLY_SIGN.equals(operator);
    }

    public boolean isDividedSign(String operator) {
        return DIVIDED_SIGN.equals(operator);
    }

}
