package domain;

public class Subtraction implements Calculation {

    @Override
    public int calculate(int first, int second) {
        return first - second;
    }
}
