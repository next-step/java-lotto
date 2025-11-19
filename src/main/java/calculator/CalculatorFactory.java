package calculator;

public class CalculatorFactory {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MULTI = "*";
    private static final String DIV = "/";


    public int handleWayByOperator(String operator, int left, int right) {
        if (operator.equals(ADD)) {
            return add(left, right);
        }

        if (operator.equals(SUB)) {
            return sub(left, right);
        }

        if (operator.equals(MULTI)) {
            return multi(left, right);
        }

        if(operator.equals(DIV)) {
            return div(left, right);
        }

        throw new IllegalArgumentException("사칙연산 기호만 입력 할 수 있습니다");
    }

    public int add(int left, int right) {
        return left + right;
    }

    public int sub(int left, int right) {
        return left - right;
    }

    public int multi(int left, int right) {
        return left * right;
    }

    public int div(int left, int right) {
        return left / right;
    }
}
