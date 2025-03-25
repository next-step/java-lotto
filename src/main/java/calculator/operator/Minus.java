package calculator.operator;

public class Minus implements Operator {

    @Override
    public boolean isOperator(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
