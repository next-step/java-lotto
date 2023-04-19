package stringcalculator;

public class Subtraction implements Operator {
    @Override
    public int apply(int num1, int num2) {
        return num1 - num2;
    }
}
