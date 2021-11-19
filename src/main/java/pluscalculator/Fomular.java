package pluscalculator;

public abstract class Fomular implements FomularInterface {
    private static final int MIN_VALUE = 0;

    protected void validateMinusNum(String s) {
        int num = Integer.parseInt(s);
        if (num < MIN_VALUE) {
            throw new RuntimeException();
        }
    }
}
