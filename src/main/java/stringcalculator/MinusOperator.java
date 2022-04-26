package stringcalculator;

public class MinusOperator implements Operator {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
