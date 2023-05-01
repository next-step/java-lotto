package stringcalculator.domain;

public class Multiplication implements Operator {
    @Override
    public int calculate(int x, int y) {
        return x * y;
    }
}
