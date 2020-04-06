package calculator;

public class Number {

    private final int number;

    public Number(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
    }

    public int getNumber() {
        return this.number;
    }
}
