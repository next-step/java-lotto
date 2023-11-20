package step1;

public class Operator {

    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public  boolean isPlusOperator() {
        return "+".equals(operator);
    }

    private  boolean isMinusOperator() {
        return "-".equals(operator);
    }

    private  boolean isMultiplyOperator() {
        return "*".equals(operator);
    }

    private  boolean isDivideOperator() {
        return "/".equals(operator);
    }

    public int calculate(int a, int b) {
        if(isPlusOperator()) {
            return a+b;
        }
        if(isMinusOperator()) {
            return a-b;
        }
        if(isMultiplyOperator()) {
            return a*b;
        }
        if(isDivideOperator()) {
            return a/b;
        }
        throw new IllegalArgumentException("invalid operator");
    }
}
