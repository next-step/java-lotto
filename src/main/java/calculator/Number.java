package calculator;

public class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Number sum(Number number) {
        return new Number(this.number + number.number);
    }

}
