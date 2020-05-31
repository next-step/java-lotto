package stringAddCalculate;

public class Number {
    private final int number;

    public Number(int number) {
        checkNegative(number);
        this.number = number;
    }

    private void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    public int getNumber() {
        return number;
    }
}
