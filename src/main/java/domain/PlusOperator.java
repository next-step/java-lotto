package domain;

public class PlusOperator implements Operator {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
