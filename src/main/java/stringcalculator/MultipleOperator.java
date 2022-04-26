package stringcalculator;

public class MultipleOperator implements Operator {
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}
