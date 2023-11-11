package step1.domain.operator.impl;

import step1.domain.operator.Operator;

public class Subtract implements Operator {

        private final static String SUBTRACT_OPERATOR = "-";

        @Override
        public int operate(int first, int second) {
            return first - second;
        }

        @Override
        public boolean supports(String operator) {
            return SUBTRACT_OPERATOR.equals(operator);
        }
}
