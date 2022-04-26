package stringcalculator;

public class DivideOperator implements Operator {
    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}
