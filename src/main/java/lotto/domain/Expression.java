package lotto.domain;

import lotto.exception.IllegalOperatorExpression;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Expression {

    private static final String NUMBER_REGEX = "\\d+";
    private static final String ADD_SIGN = "+";
    private static final String SUBTRACT_SIGN = "-";
    private static final String MULTIPLY_SIGN = "*";
    private static final String DIVIDED_SIGN = "/";

    private final Set<String> OPERATOR_SET = new LinkedHashSet<>() {{
        add(ADD_SIGN);
        add(SUBTRACT_SIGN);
        add(MULTIPLY_SIGN);
        add(DIVIDED_SIGN);
    }};

    // TODO: 일급 컬렉션을 상태로 가짐으로서 발생하는 .get() 체이닝 문제
    // (현재) Calculator -> Expression -> Numbers & Operators (Queue)
    // (개선 가능한 방향) Calculator -> Expression (2 Queues)
    private final Numbers numbers;
    private final Operators operators;

    public Expression(List<String> expressionElements) {
        this.numbers = new Numbers();
        this.operators = new Operators();

        for (String element : expressionElements) {
            addNumberOrOperator(element);
        }
    }

    private void addNumberOrOperator(String element) throws IllegalOperatorExpression {
        if (isNumber(element)) {
            addNumber(element);
            return;
        }

        validateOperation(element);
        addOperator(element);
    }

    private void validateOperation(String operator) {
        if (notContainOperator(operator)) {
            throw new IllegalOperatorExpression(IllegalOperatorExpression.formatMessage(operator, OPERATOR_SET));
        }
    }

    private void addNumber(String element) {
        numbers.add(parseInt(element));
    }

    private void addOperator(String element) {
        operators.add(element);
    }

    private boolean isNumber(String element) {
        return element.matches(NUMBER_REGEX);
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
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

    private boolean notContainOperator(String operator) {
        return !OPERATOR_SET.contains(operator);
    }

}
