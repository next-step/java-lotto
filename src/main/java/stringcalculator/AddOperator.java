package stringcalculator;

public class AddOperator implements Operator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
