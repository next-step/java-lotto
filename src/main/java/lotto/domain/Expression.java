package lotto.domain;

import lotto.exception.ExpressionNumberParseException;

import java.util.Queue;

public class Expression {

    private static final String NUMBER_REGEX = "\\d+";

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
}
