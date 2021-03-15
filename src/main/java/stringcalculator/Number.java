package stringcalculator;

public class Number {

    private int number;

    public Number(int number) {
        isNegative(number);

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void isNegative(int data) {
        if (data < 0) {
            throw new RuntimeException();
        }
    }
}
