package Operator;

import java.util.Arrays;

public enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE;

    private static Character operatorsArr[] = { '+', '-', '*', '/' };

    public static Operator check (Character operator) {
        switch (operator) {
            case '+':
                return PLUS;
            case '-':
                return MINUS;
            case '*':
                return MULTIPLY;
            case '/':
                return DIVIDE;

            default:
                throw new IllegalArgumentException("Operator가 아닙니다.");
        }
    }

    public static void isValid(Character input) {
        boolean retval = Arrays.asList(operatorsArr).contains(input);
        if( !retval ){
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }
}
