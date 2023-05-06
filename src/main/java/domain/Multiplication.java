package domain;

public class Multiplication implements Calculation {

    @Override
    public int calculate(int first, int second) {
        return first * second;
    }
}
