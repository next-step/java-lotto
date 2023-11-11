package step1.domain.operator.impl;

import step1.domain.operator.Operator;

public class Multiply implements Operator {

        private final static String MULTIPLY_OPERATOR = "*";

        @Override
        public int operate(int first, int second) {
            return first * second;
        }

        @Override
        public boolean supports(String operator) {
            return MULTIPLY_OPERATOR.equals(operator);
        }
}
