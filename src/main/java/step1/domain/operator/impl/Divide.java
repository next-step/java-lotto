package step1.domain.operator.impl;

import step1.domain.operator.Operator;

public class Divide implements Operator {

        private final static String DIVIDE_OPERATOR = "/";

        @Override
        public int operate(int first, int second) {
            return first / second;
        }

        @Override
        public boolean supports(String operator) {
            return DIVIDE_OPERATOR.equals(operator);
        }
}
