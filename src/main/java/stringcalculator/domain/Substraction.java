package stringcalculator.domain;

public class Substraction implements Operator {
    @Override
    public int calculate(int x, int y) {
        return x - y;
    }
}
