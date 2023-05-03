package domain;

public class Addition implements Calculation {

    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
