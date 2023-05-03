package domain;

public class Division implements Calculation {

    @Override
    public int calculate(int first, int second) {
        return first / second;
    }
}
