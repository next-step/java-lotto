package stringcalculator;

public class Addition implements Operator {
    @Override
    public int apply(int x, int y) {
        return x + y;
    }
}
