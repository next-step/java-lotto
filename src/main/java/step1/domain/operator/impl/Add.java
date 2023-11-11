package step1.domain.operator.impl;

import step1.domain.operator.Operator;

public class Add implements Operator {

    private final static String ADD_OPERATOR = "+";

    @Override
    public int operate(int first, int second) {
        return first + second;
    }

    @Override
    public boolean supports(String operator) {
        return ADD_OPERATOR.equals(operator);
    }
}
