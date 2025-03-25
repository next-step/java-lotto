package calculator.operator;

public interface Operator {

    public boolean isOperator(String operator);

    public int calculate(int a, int b);
}
