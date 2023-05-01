package stringcalculator.domain;

public class Addition implements Operator {

    @Override
    public int calculate(int x, int y) {
        return x + y;
    }
}
