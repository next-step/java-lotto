package step1.domain;

public class Calculator {

    private final static String ADD_OPERATOR = "+";
    private final static String SUBTRACT_OPERATOR = "-";
    private final static String MULTIPLY_OPERATOR = "*";
    private final static String DIVIDE_OPERATOR = "/";

    public int calculate(String operator, int first, int second) {
        switch(operator){
            case ADD_OPERATOR:
                return this.add(first, second);
            case SUBTRACT_OPERATOR:
                return this.subtract(first, second);
            case MULTIPLY_OPERATOR:
                return this.multiply(first, second);
            case DIVIDE_OPERATOR:
                return this.divide(first, second);
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    private int add(int first, int second) {
        return first + second;
    }

    private int subtract(int first, int second) {
        return first - second;
    }

    private int multiply(int first, int second) {
        return first * second;
    }

    private int divide(int first, int second) {
        return first / second;
    }

}
